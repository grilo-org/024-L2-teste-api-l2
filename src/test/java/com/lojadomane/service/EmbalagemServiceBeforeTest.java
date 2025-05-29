package com.lojadomane.service;

import com.lojadomane.model.Dimensoes;
import com.lojadomane.model.Produto;
import com.lojadomane.model.Pedido;
import com.lojadomane.dto.PedidoResponse;
import com.lojadomane.dto.CaixaResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmbalagemServiceBeforeTest {

    private EmbalagemService embalagemService;

    @BeforeEach
    void setUp() {
        embalagemService = new EmbalagemService();
    }

    @Test
    void deveEmpacotarProdutoQueCabeNaCaixa1_comBefore() {
        Produto headset = new Produto("Headset", new Dimensoes(25, 15, 20));
        Pedido pedido = new Pedido(100, List.of(headset));

        PedidoResponse resp = embalagemService.embalar(List.of(pedido)).get(0);
        CaixaResponse caixa = resp.getCaixas().get(0);

        assertEquals(100, resp.getPedidoId());
        assertEquals("Caixa 1", caixa.getCaixaId());
        assertTrue(caixa.getProdutos().contains("Headset"));
        assertNull(caixa.getObservacao());
    }
}
