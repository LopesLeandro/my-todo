package com.example.application.views;

import com.example.application.backend.Gasto;
import com.example.application.backend.GastoRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("observar-despesas")
public class ObservarDespesasView extends VerticalLayout {
    private GastoRepository gastoRepository = new GastoRepository();
    private Grid<Gasto> grid = new Grid<>(Gasto.class);
    private Select<String> tipoGastoFilter = new Select<>();

    public ObservarDespesasView() {
        tipoGastoFilter.setItems("Habitação", "Alimentação", "Transporte", "Lazer", "Outros");
        tipoGastoFilter.setLabel("Filtrar por Tipo de Gasto");
        tipoGastoFilter.addValueChangeListener(e -> filterByTipoGasto(e.getValue()));


        add(tipoGastoFilter, grid);
        updateGrid();
    }

    private void filterByTipoGasto(String tipoGasto) {
        List<Gasto> gastos = gastoRepository.getByTipoGasto(tipoGasto); // Suponha que você tenha um método getByTipoGasto() no seu repositório

        grid.setItems(gastos);
    }

    private void updateGrid() {
        List<Gasto> gastos = gastoRepository.getAll();

        grid.setItems(gastos);
    }
}