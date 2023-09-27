package com.example.application.backend;

import java.time.LocalDate;

public class Gasto {
    private int id;
    private String tipo;
    private LocalDate data;
    private double valor;
    private String formaDePagamento;

    public Gasto(int id, String tipo, LocalDate data, double valor, String formaDePagamento) {
        this.id = id;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
        this.formaDePagamento = formaDePagamento;
    }

    public int getId() {
        return this.id;
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

