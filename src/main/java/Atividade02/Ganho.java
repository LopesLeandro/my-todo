package Atividade02;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ganho {
    private final int id;
    private String tipo;
    private LocalDate data;
    private double valor;

    public Ganho(int id, String tipo, LocalDate data, double valor) {
        this.id = id;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }
    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public int getId() {
        return id;
    }
}
