package com.lojadomane.model;

import java.util.List;

public class Caixa {
    private final String caixaId;
    private final Dimensoes dimensoes;

    public Caixa(String caixaId, Dimensoes dimensoes) {
        this.caixaId = caixaId;
        this.dimensoes = dimensoes;
    }

    public String caixaId() { return caixaId; }
    public Dimensoes dimensoes() { return dimensoes; }

    public static final Caixa CAIXA1 = new Caixa("Caixa 1", new Dimensoes(30, 40, 80));
    public static final Caixa CAIXA2 = new Caixa("Caixa 2", new Dimensoes(80, 50, 40));
    public static final Caixa CAIXA3 = new Caixa("Caixa 3", new Dimensoes(50, 80, 60));

    public static List<Caixa> lstCaixas() {
        return List.of(CAIXA1, CAIXA2, CAIXA3);
    }
}
