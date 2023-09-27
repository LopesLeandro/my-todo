package com.example.application.views;

import com.example.application.backend.Gasto;
import com.example.application.backend.GastoRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;

import java.util.List;


@Route("")
public class MainView extends VerticalLayout {
    GastoRepository gastoRepository = new GastoRepository();
    Grid<Gasto> grid = new Grid<>(Gasto.class);

    private final Dialog editDialog = new Dialog();

    public MainView() {


        add(
                new H1("Gestão Financeira")

        );

        setupAddGastoSection(); // Adiciona a seção de adicionar gasto

//        grid.addColumn(Gasto::getTipo).setHeader("Tipo de Gasto");
//        grid.addColumn(Gasto::getData).setHeader("Data do Gasto");
//        grid.addColumn(Gasto::getValor).setHeader("Valor do Gasto");
//        grid.addColumn(Gasto::getFormaDePagamento).setHeader("Forma de Pagamento");



        grid.addComponentColumn(gasto -> {
            Button deleteButton = new Button("Deletar", clickEvent -> {
                gastoRepository.deleteById(gasto.getId());
                updateGrid();
            });
            Button editButton = new Button("Editar", clickEvent -> openEditDialog(gasto));
            HorizontalLayout buttonLayout = new HorizontalLayout(editButton, deleteButton);
            buttonLayout.setAlignItems(Alignment.CENTER); // Ajuste a alinhamento dos botões

            return buttonLayout;
        }).setHeader("Ações");



        add(grid);
        updateGrid();
    }

    private void setupAddGastoSection() {

        Select<String> tipoGastoSelect = new Select<>();
        tipoGastoSelect.setItems("Habitação", "Alimentação", "Transporte", "Lazer", "Outros");
        tipoGastoSelect.setLabel("Tipo de Gasto");

        DatePicker dataGastoPicker = new DatePicker("Data do Gasto");
        NumberField valorGastoField = new NumberField("Valor do Gasto");

        Select<String> formaPagamentoSelect = new Select<>();
        formaPagamentoSelect.setItems("Dinheiro", "Débito", "Crédito", "Pix");
        formaPagamentoSelect.setLabel("Forma de Pagamento");

        Button addGastoButton = new Button("Adicionar Gasto");

        addGastoButton.addClickListener(e -> {
            Gasto gasto = new Gasto(
                    0,
                    tipoGastoSelect.getValue(),
                    dataGastoPicker.getValue(),
                    valorGastoField.getValue(),
                    formaPagamentoSelect.getValue());
//            System.out.println(gasto);
            gastoRepository.addToDataBase(gasto);
            updateGrid();


        });

        add(
                tipoGastoSelect,
                dataGastoPicker,
                valorGastoField,
                formaPagamentoSelect,
                addGastoButton
        ); // Adiciona os componentes na tela

    }


    private void openEditDialog(Gasto gasto) {
        editDialog.removeAll();

        Select<String> editTipoGastoSelect = new Select<>();
        editTipoGastoSelect.setItems("Habitação", "Alimentação", "Transporte", "Lazer", "Outros");
        editTipoGastoSelect.setLabel("Tipo de Gasto");
        editTipoGastoSelect.setValue(gasto.getTipo());

        DatePicker editDataGastoPicker = new DatePicker("Data do Gasto");
        editDataGastoPicker.setValue(gasto.getData()); // Usando o método getLocalDate

        NumberField editValorGastoField = new NumberField("Valor do Gasto");
        editValorGastoField.setValue(gasto.getValor());

        Select<String> editFormaPagamentoSelect = new Select<>();
        editFormaPagamentoSelect.setItems("Dinheiro", "Débito", "Crédito", "Pix");
        editFormaPagamentoSelect.setLabel("Forma de Pagamento");
        editFormaPagamentoSelect.setValue(gasto.getFormaDePagamento());

        Button saveButton = new Button("Salvar", e -> {
            gasto.setTipo(editTipoGastoSelect.getValue());
            gasto.setData(editDataGastoPicker.getValue());
            gasto.setValor(editValorGastoField.getValue());
            gasto.setFormaDePagamento(editFormaPagamentoSelect.getValue());
            editDialog.close();
            updateGrid();
        });

        editDialog.add(
                editTipoGastoSelect,
                editDataGastoPicker,
                editValorGastoField,
                editFormaPagamentoSelect,
                saveButton
        );
        editDialog.open();
    }

    private void updateGrid() {
        List<Gasto> gastos = gastoRepository.getAll(); // Suponha que você tenha um método getAll() que busca os gastos do banco de dados

        // Limpa todas as colunas existentes no Grid
//        grid.removeAllColumns();

//        // Adiciona as colunas que deseja exibir
//        grid.addColumn(Gasto::getTipo).setHeader("Tipo de Gasto");
//        grid.addColumn(Gasto::getData).setHeader("Data do Gasto");
//        grid.addColumn(Gasto::getValor).setHeader("Valor do Gasto");
//        grid.addColumn(Gasto::getFormaDePagamento).setHeader("Forma de Pagamento");

        // Define os itens no Grid
        grid.setItems(gastos);
    }

}
