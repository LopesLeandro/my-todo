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

    private Connection conexao;

    public GastoRepository() {
        try {
            conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/gastos",
                    "root",
                    "1234567"
            );
            System.out.println("Conexão ao banco de dados estabelecida");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addToDataBase(Gasto gasto) {
        System.out.println("Adicionando gasto ao banco de dados");
        String sql = "INSERT INTO despesas (TIPO_DESPESA, DATA_DESPESA, VALOR_DESPESA, TIPO_PAGAMENTO) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, gasto.getTipo());
            System.out.printf("Tipo adicionado: %s%n", gasto.getTipo());
            stmt.setDate(2, Date.valueOf(gasto.getData()));
            System.out.printf("Data adicionada: %s%n",Date.valueOf(gasto.getLocalDate()));
            stmt.setDouble(3, gasto.getValor());
            System.out.printf("Valor adicionado: %s%n", gasto.getValor());
            stmt.setString(4, gasto.getFormaDePagamento());
            System.out.printf("Forma de pagamento adicionada: %s%n", gasto.getFormaDePagamento());
            stmt.executeUpdate();
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

//    public void delete(Gasto gasto) {
//        String sql = "DELETE FROM despesas WHERE id = ?";
//        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
//            stmt.setInt(1, gasto.getId());
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void update(Gasto gasto) {
//        String sql = "UPDATE Gastos SET tipo = ?, data = ?, valor = ?, formaPagamento = ? WHERE id = ?";
//        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
//            stmt.setString(1, gasto.getTipo());
//            stmt.setDate(2, Date.valueOf(gasto.getData()));
//            stmt.setDouble(3, gasto.getValor());
//            stmt.setString(4, gasto.getFormaDePagamento());
//            stmt.setInt(5, gasto.getId());
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}


