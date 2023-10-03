package Atividade02;
import com.example.application.backend.Gasto;

import java.util.ArrayList;
import java.util.List;

public class Financeiro {
    private List<Gasto> gastos;
    private List<Ganho> ganhos;

    public Financeiro() {
        this.gastos = new ArrayList<>();
        this.ganhos = new ArrayList<>();
    }

    public void adicionarGasto(Gasto gasto) {
        gastos.add(gasto);
    }

    public void adicionarGanho(Ganho ganho) {
        ganhos.add(ganho);
    }

//    public void relatorioGastos() {
//        System.out.println("Relatório de Gastos");
//        System.out.println("--------------------");
//        Map<String, Double> gastosPorTipo = new HashMap<>();
//
//        for (Gasto gasto : gastos) {
//            gastosPorTipo.put(gasto.getTipo(), gastosPorTipo.getOrDefault(gasto.getTipo(), 0.0) + gasto.getValor());
//        }
//
//        for (Map.Entry<String, Double> entry : gastosPorTipo.entrySet()) {
//            System.out.printf("%s: R$ %.2f%n", entry.getKey(), entry.getValue());
//        }
//    }

//    public void relatorioGanhos() {
//        System.out.println("Relatório de Ganhos");
//        System.out.println("--------------------");
//        Map<String, Double> ganhosPorTipo = new HashMap<>();
//
//        for (Ganho ganho : ganhos) {
//            ganhosPorTipo.put(ganho.getTipo(), ganhosPorTipo.getOrDefault(ganho.getTipo(), 0.0) + ganho.getValor());
//        }
//
//        for (Map.Entry<String, Double> entry : ganhosPorTipo.entrySet()) {
//            System.out.printf("%s: R$ %.2f%n", entry.getKey(), entry.getValue());
//        }
//    }

//    public void relatorioMensal(YearMonth selectedMonth) {
//        System.out.println("Relatório Mensal");
//        System.out.println("-----------------");
//        System.out.println("Mês: " + selectedMonth.getMonth().toString() + "/" + selectedMonth.getYear());
//
//        double totalGastos = gastos.stream()
////                .filter(gasto -> YearMonth.from(getLocalDateFromString(gasto.getData())).equals(selectedMonth))
//                .mapToDouble(Gasto::getValor)
//                .sum();
//
//        double totalGanhos = ganhos.stream()
//                .filter(ganho -> YearMonth.from(getLocalDateFromString(ganho.getData())).equals(selectedMonth))
//                .mapToDouble(Ganho::getValor)
//                .sum();
//
//        double saldo = totalGanhos - totalGastos;
//
//        System.out.printf("Ganho Total: R$ %.2f%n", totalGanhos);
//        System.out.printf("Gasto Total: R$ %.2f%n", totalGastos);
//        System.out.printf("Saldo: R$ %.2f%n", saldo);
//    }


//    private LocalDate getLocalDateFromString(String dateStr) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        return LocalDate.parse(dateStr, formatter);
//    }
}
