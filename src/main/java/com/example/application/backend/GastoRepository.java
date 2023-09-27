package com.example.application.backend;

import java.util.ArrayList;
import java.util.List;
import com.example.application.backend.Gasto;

//public class GastoRepository {
//    private final List<Gasto> gastos = new ArrayList<>();
//
//    public void add(Gasto gasto) {
//        gastos.add(gasto);
//    }
//
//    public List<Gasto> getAll() {
//        return new ArrayList<>(gastos);
//    }
//
//    public void delete(Gasto gasto) {
//        gastos.remove(gasto);
//    }
//
//
//}

import java.sql.*;

public class GastoRepository {

    private List<Gasto> gastos = new ArrayList<>();

    private Connection conexao;

    public GastoRepository() {
        try {
            conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/gastos",
                    "root",
                    "1234567"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addToDataBase(Gasto gasto) {
        String sql = "INSERT INTO despesas (TIPO_DESPESA, DATA_DESPESA, VALOR_DESPESA, TIPO_PAGAMENTO) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, gasto.getTipo());
            ps.setDate(2, Date.valueOf(gasto.getData()));
            ps.setDouble(3, gasto.getValor());
            ps.setString(4, gasto.getFormaDePagamento());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Gasto> getAll() {
        List<Gasto> gastos = new ArrayList<>();
        String sql = "SELECT * FROM despesas";
        try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Gasto gasto = new Gasto(
                        rs.getInt("id"),
                        rs.getString("TIPO_DESPESA"),
                        rs.getDate("DATA_DESPESA").toLocalDate(),
                        rs.getDouble("VALOR_DESPESA"),
                        rs.getString("TIPO_PAGAMENTO")
                );
                gastos.add(gasto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gastos;
    }

    public void delete(Gasto gasto) {
        String sql = "DELETE FROM despesas WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, gasto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void update(Gasto gasto) {
        String sql = "UPDATE despesas SET TIPO_DESPESA = ?, DATA_DESPESA = ?, VALOR_DESPESA = ?, TIPO_PAGAMENTO = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, gasto.getTipo());
            stmt.setDate(2, Date.valueOf(gasto.getData()));
            stmt.setDouble(3, gasto.getValor());
            stmt.setString(4, gasto.getFormaDePagamento());
            stmt.setInt(5, gasto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Gasto> getByTipoGasto(String tipoGasto) {
        List<Gasto> gastos = new ArrayList<>();
        String sql = "SELECT * FROM despesas WHERE TIPO_DESPESA = ?";

        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setString(1, tipoGasto);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Gasto gasto = new Gasto(
                        resultSet.getInt("id"),
                        resultSet.getString("TIPO_DESPESA"),
                        resultSet.getDate("DATA_DESPESA").toLocalDate(),
                        resultSet.getDouble("VALOR_DESPESA"),
                        resultSet.getString("TIPO_PAGAMENTO")
                );
                gastos.add(gasto);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gastos;
    }
}


