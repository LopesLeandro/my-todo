package com.example.application.views;

import Atividade02.Gasto;
//import com.example.application.utils.ViewUtils;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.Span;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Route("SecondView")
public class SecondView extends VerticalLayout {
    GastoRepository gastoRepository = new GastoRepository();
    Grid<Gasto> grid = new Grid<>(Gasto.class);

    public SecondView() {
        add(new H1("Gestão Financeira - Relatório"));
        Button backbutton = new Button("Voltar", e -> {
            getUI().ifPresent(ui -> ui.navigate(""));
        });
        add(backbutton);
        DatePicker startDatePicker = new DatePicker("Data Inicial");
        DatePicker endDatePicker = new DatePicker("Data Final");
        Button searchButton = new Button("Buscar", e -> updateGrid(startDatePicker.getValue(), endDatePicker.getValue()));

        add(startDatePicker, endDatePicker, searchButton, grid, totalSpan);
        add(totalSpan);
        updateGrid(null, null);
    }


    private void updateGrid(LocalDate startDate, LocalDate endDate) {
        List<Gasto> allGastos = gastoRepository.getAll();
        if (startDate != null && endDate != null) {
            allGastos = allGastos.stream()
                    .filter(gasto -> !gasto.getData().isBefore(startDate) && !gasto.getData().isAfter(endDate))
                    .collect(Collectors.toList());
        }
        grid.setItems(allGastos);
        updateTotal(allGastos);
    }

    private void botaoGastos() {
        Button reportButton = new Button("Gastos", e -> {
            getUI().ifPresent(ui -> ui.navigate(""));
        });
        add(reportButton);
    }

    private static final Span totalSpan = new Span();

    public void updateTotal(List<Gasto> allGastos) {
        double total = allGastos.stream().mapToDouble(Gasto::getValor).sum();
        totalSpan.setText("Total: R$ " + total);
    }
}
