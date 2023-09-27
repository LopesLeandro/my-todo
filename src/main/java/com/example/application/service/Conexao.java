package com.example.application.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
    public static void main(String[] args) {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gastos", "root", "1234567");
            ResultSet rsBanco = conexao.createStatement().executeQuery("SELECT * FROM despesas");
            while (rsBanco.next()) {
                System.out.println(rsBanco.getString("tipo"));
            }
            System.out.println("Driver do banco de dados localizado");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver do banco de dados não localizado");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Ocorreu outro erro ao tentar conectar ao banco de dados: " + e.getMessage());
        } finally {
            try {
                if (conexao != null && !conexao.isClosed()) {
                    conexao.close();
                    System.out.println("Conexão ao banco de dados encerrada");
                }
            } catch (SQLException e) {
                System.out.println("Erro ao encerrar a conexão: " + e.getMessage());
            }
        }
    }
}

