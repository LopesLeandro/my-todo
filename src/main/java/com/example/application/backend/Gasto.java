package com.example.application.backend;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Gasto {
    private int id;
    private String tipo;
    private LocalDate data;
    private double valor;
    private String formaDePagamento;

    public Gasto(String tipo, LocalDate data, double valor, String formaDePagamento) {
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
        this.formaDePagamento = formaDePagamento;
    }

    // Métodos Setters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    // Método adicional para obter LocalDate
//    public LocalDate getLocalDate() {
//        return data;
//    }
    public String getTipo() {
        return tipo;
    }

    public LocalDate getData() {;
        return data;
    }

    public double getValor() {
        return valor;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

//    public int getId() {
//        //Add o ID random
//        int Id = (int) (Math.random() * 1000);
//        return Id;
//    }

//    public void setId(int id) {
//        this.id = id;
//    }

    @Override
    public String toString() {
        return "Gasto{" +
                "tipo='" + tipo + '\'' +
                ", data=" + data +
                ", valor=" + valor +
                ", formaDePagamento='" + formaDePagamento + '\'' +
                '}';
    }
}

