package Atividade02;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Gasto {
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
    public LocalDate getLocalDate() {
        return data;
    }
    public String getTipo() {
        return tipo;
    }

    public String getData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }

    public double getValor() {
        return valor;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }
}
