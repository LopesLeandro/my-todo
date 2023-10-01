package Atividade02;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Financeiro financeiro = new Financeiro();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.println("-----------------------");
            System.out.println("|  Gestão  Financeira |");
            System.out.println("-----------------------");
            System.out.println("1 - Adicionar Gastos");
            System.out.println("2 - Adicionar Ganhos");
            System.out.println("3 - Relatório de Gastos");
            System.out.println("4 - Relatório de Ganhos");
            System.out.println("5 - Relatório Mensal");
            System.out.println("6 - Sair");
            System.out.println("Selecione uma opção:");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Adicionar Gasto");
                    System.out.println("-----------------------");
                    System.out.println("Informe o tipo de gasto: [Habitação] [Alimentação] [Transporte] [Lazer] [Outros]");
                    String tipoGasto = scanner.nextLine();
                    System.out.println("Informe a data (formato: DD/MM/AAAA):");
                    LocalDate dataGasto = LocalDate.parse(scanner.nextLine(), formatter);
                    System.out.println("Informe o valor: R$ ");
                    double valorGasto = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Selecione a forma de pagamento: [Dinheiro] [Débito] [Crédito] [Pix]");
                    String formaDePagamento = scanner.nextLine();

                    int id = 0;
                    Gasto gasto = new Gasto(id, tipoGasto, dataGasto, valorGasto, formaDePagamento);
                    financeiro.adicionarGasto(gasto);
                    break;

                case 2:
                    System.out.println("Adicionar Ganho");
                    System.out.println("-----------------------");
                    System.out.println("Informe o tipo de ganho: [Salário] [Investimentos] [Outros]");
                    String tipoGanho = scanner.nextLine();
                    System.out.println("Informe a data (formato: DD/MM/AAAA):");
                    LocalDate dataGanho = LocalDate.parse(scanner.nextLine(), formatter);
                    System.out.println("Informe o valor: R$");
                    double valorGanho = scanner.nextDouble();
                    scanner.nextLine();
                    int idG = 0;
                    Ganho ganho = new Ganho(idG,tipoGanho, dataGanho, valorGanho);
                    financeiro.adicionarGanho(ganho);
                    break;

                case 3:
//                    financeiro.relatorioGastos();
                    break;

                case 4:
//                    financeiro.relatorioGanhos();
                    break;

                case 5:
                    System.out.println("Informe o mês e ano que deseja verificar (formato: MM/AAAA):");
                    String monthYearInput = scanner.nextLine();
                    DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MM/yyyy");
                    YearMonth selectedMonth = YearMonth.parse(monthYearInput, monthYearFormatter);
//                    financeiro.relatorioMensal(selectedMonth);
                    break;

                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
