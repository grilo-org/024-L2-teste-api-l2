package com.lojadomane.service;

import com.lojadomane.model.Dimensoes;
import com.lojadomane.model.Produto;
import com.lojadomane.model.Pedido;
import com.lojadomane.dto.PedidoResponse;
import com.lojadomane.dto.CaixaResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.lojadomane.service.EmbalagemService;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmbalagemServiceTest {

    private EmbalagemService embalagemService;

    @BeforeEach
    void setUp() {
        embalagemService = new EmbalagemService();
    }

    @Test
    void deveEmpacotarProdutoQueCabeNaCaixa1() {
        Produto headset = new Produto("Headset", new Dimensoes(25, 15, 20));
        Pedido pedido = new Pedido(1, List.of(headset));

        List<PedidoResponse> resultados = embalagemService.embalar(List.of(pedido));

        assertEquals(1, resultados.size());
        PedidoResponse resp = resultados.get(0);
        assertEquals(1, resp.getPedidoId());

        List<CaixaResponse> caixas = resp.getCaixas();
        assertEquals(1, caixas.size());
        CaixaResponse caixa = caixas.get(0);
        assertEquals("Caixa 1", caixa.getCaixaId());
        assertTrue(caixa.getProdutos().contains("Headset"));
        assertNull(caixa.getObservacao());
    }
}
