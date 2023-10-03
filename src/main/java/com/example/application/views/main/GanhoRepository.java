package com.example.application.views.main;

import Atividade02.Ganho;
import Atividade02.Gasto;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class GanhoRepository {
    private final List<Ganho> ganhos = new ArrayList<>();
    public static Connection conexao;



    public GanhoRepository() {
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

    public static List<Ganho> getAll() {
        List<Ganho> ganhos = new ArrayList<>();
        String sql = "SELECT * FROM ganhos";
        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String tipo = rs.getString("tipo");
                LocalDate data = rs.getDate("data").toLocalDate();
                double valor = rs.getDouble("valor");

                Ganho ganho = new Ganho(id, tipo, data, valor);
                ganhos.add(ganho);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ganhos;
    }


    public void add(Ganho ganhos) {
        System.out.println("Se imprimiu é porque chamou o método add");
        String sql = "INSERT INTO ganhos (id, tipo, data, valor) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, ganhos.getId());
            stmt.setString(2, ganhos.getTipo());
            stmt.setDate(3, Date.valueOf(ganhos.getData()));
            stmt.setDouble(4, ganhos.getValor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Ganho ganhos) {
        String sql = "DELETE FROM ganhos WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, ganhos.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Ganho ganhos){
        String sql = "UPDATE ganhos SET tipo = ?, data = ?, valor = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, ganhos.getTipo());
            stmt.setDate(2, Date.valueOf(ganhos.getData()));
            stmt.setDouble(3, ganhos.getValor());
            stmt.setInt(5, ganhos.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

