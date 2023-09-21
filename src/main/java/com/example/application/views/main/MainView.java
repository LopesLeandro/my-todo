//package com.example.application.views.main;
//
//import com.vaadin.flow.component.Key;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.checkbox.Checkbox;
//import com.vaadin.flow.component.html.H1;
//import com.vaadin.flow.component.html.Span;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.router.Route;
//
//@Route("")
//public class MainView extends VerticalLayout {
//
//    public MainView() {
//        VerticalLayout todosList = new VerticalLayout();
//        TextField taskField = new TextField();
//        Button addButton = new Button("Add");
//        addButton.addClickListener(click -> {
//            Checkbox checkbox = new Checkbox(taskField.getValue());
//            todosList.add(checkbox);
//        });
//        Span pendingPrimary = new Span("Pending");
//        pendingPrimary.getElement().getThemeList().add("badge primary");
//
//        add(
//                new H1("Vaadin Todo"),
//                todosList,
//                new HorizontalLayout(
//                        taskField,
//                        addButton
//                ),
//                new Span("Ja da para ser pleno"),
//                pendingPrimary
//        );
//    }
//}

package com.example.application.views.main;

import Atividade02.Financeiro;
import Atividade02.Gasto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    Financeiro financeiro = new Financeiro();

    public MainView() {
        add(new H1("Gestão Financeira"));

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
                    tipoGastoSelect.getValue(),
                    dataGastoPicker.getValue(),
                    valorGastoField.getValue(),
                    formaPagamentoSelect.getValue());
            financeiro.adicionarGasto(gasto);
            // Aqui você pode adicionar uma notificação ou atualizar uma lista/grid na UI


        });

        add(tipoGastoSelect, dataGastoPicker, valorGastoField, formaPagamentoSelect, addGastoButton);
    }
}
