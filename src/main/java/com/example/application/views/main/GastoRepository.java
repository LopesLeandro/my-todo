package com.example.application.views.main;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Atividade02.Gasto;

import static java.sql.Date.valueOf;


public class GastoRepository {
    private final List<Gasto> gastos = new ArrayList<>();
    private Connection conexao;

    public GastoRepository() {
        try {
            conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/BancoFinanceiro",
                    "root",
                    "@Ruth12345"
            );
            System.out.println("Conexão ao banco de dados estabelecida");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Gasto> getAll() {
        List<Gasto> gastos = new ArrayList<>();
        String sql = "SELECT * FROM gastos";
        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String tipo = rs.getString("tipo");
                LocalDate data = rs.getDate("data").toLocalDate();
                double valor = rs.getDouble("valor");
                String formaDePagamento = rs.getString("formaPagamento");

                Gasto gasto = new Gasto(id, tipo, data, valor, formaDePagamento);
                gastos.add(gasto);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gastos;
    }


    public void add(Gasto gasto) {
        System.out.println("Se imprimiu é porque chamou o método add");
        String sql = "INSERT INTO gastos (tipo, data, valor, formaPagamento) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, gasto.getTipo());
            stmt.setDate(2, java.sql.Date.valueOf(gasto.getData()));
            stmt.setDouble(3, gasto.getValor());
            stmt.setString(4, gasto.getFormaDePagamento());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Gasto gasto) {
        String sql = "DELETE FROM gastos WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, gasto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Gasto gasto){
        String sql = "UPDATE gastos SET tipo = ?, data = ?, valor = ?, formaPagamento = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, gasto.getTipo());
            stmt.setDate(2, java.sql.Date.valueOf(gasto.getData()));
            stmt.setDouble(3, gasto.getValor());
            stmt.setString(4, gasto.getFormaDePagamento());
            stmt.setInt(5, gasto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

