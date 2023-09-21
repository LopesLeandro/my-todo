package com.example.application.views.main;

import java.util.ArrayList;
import java.util.List;
import Atividade02.Gasto;

public class GastoRepository {
    private final List<Gasto> gastos = new ArrayList<>();

    public void add(Gasto gasto) {
        gastos.add(gasto);
    }

    public List<Gasto> getAll() {
        return new ArrayList<>(gastos);
    }

    public void delete(Gasto gasto) {
        gastos.remove(gasto);
    }

    // Você também pode adicionar um método para editar/atualizar um Gasto se necessário
}

