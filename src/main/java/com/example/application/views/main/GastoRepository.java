package com.example.application.views.main;

import java.util.ArrayList;
import java.util.List;
import Atividade02.Gasto;

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
import java.util.ArrayList;
import java.util.List;

public class GastoRepository {

    private Connection conexao;

    public GastoRepository() {
        try {
            conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/BancoFinanceiro",
                    "root",
                    "@Ruth12345"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(Gasto gasto) {
        String sql = "INSERT INTO Gastos (tipo, data, valor, formaPagamento) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, gasto.getTipo());
            stmt.setDate(2, Date.valueOf(gasto.getData()));
            stmt.setDouble(3, gasto.getValor());
            stmt.setString(4, gasto.getFormaDePagamento());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Gasto> getAll() {
        List<Gasto> gastos = new ArrayList<>();
        String sql = "SELECT * FROM Gastos";
        try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Gasto gasto = new Gasto(
                        rs.getString("tipo"),
                        rs.getDate("data").toLocalDate(),
                        rs.getDouble("valor"),
                        rs.getString("formaPagamento")
                );
                gastos.add(gasto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gastos;
    }

    public void delete(Gasto gasto) {
        String sql = "DELETE FROM Gastos WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, gasto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Gasto gasto) {
        String sql = "UPDATE Gastos SET tipo = ?, data = ?, valor = ?, formaPagamento = ? WHERE id = ?";
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
}


