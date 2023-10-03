//package com.example.application.utils;
//
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//
//public class ViewUtils {
//
//    public static HorizontalLayout criarBotaoTopo() {
//        Button relatorioButton = new Button("Relatório", e ->
//                e.getUI().ifPresent(ui -> ui.navigate("SecondView")));
//
//        Button ganhoButton = new Button("Ganho", e ->
//                e.getUI().ifPresent(ui -> ui.navigate("TerceiraView"))); // Substituir pelo nome correto da sua View
//
//        Button gastoButton = new Button("Gastos", e ->
//                e.getUI().ifPresent(ui -> ui.navigate("")));
//
//        HorizontalLayout buttonLayout = new HorizontalLayout();
//        buttonLayout.add(relatorioButton, ganhoButton, gastoButton);
//
//        return buttonLayout;
//    }
//}
