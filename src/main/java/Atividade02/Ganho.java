package Atividade02;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ganho {
    private String tipo;
    private LocalDate data;
    private double valor;

    public Ganho(String tipo, LocalDate data, double valor) {
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
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
}
