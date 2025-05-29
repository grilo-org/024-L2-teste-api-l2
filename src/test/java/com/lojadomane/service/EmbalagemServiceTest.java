package com.lojadomane.service;

import com.lojadomane.model.Dimensoes;
import com.lojadomane.model.Produto;
import com.lojadomane.model.Pedido;
import com.lojadomane.dto.PedidoResponse;
import com.lojadomane.dto.CaixaResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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

        PedidoResponse resp = embalagemService.embalar(List.of(pedido)).get(0);

        assertEquals(1, resp.getPedidoId());
        CaixaResponse caixa = resp.getCaixas().get(0);
        assertEquals("Caixa 1", caixa.getCaixaId());
        assertTrue(caixa.getProdutos().contains("Headset"));
        assertNull(caixa.getObservacao());
    }

    @Test
    void deveEmpacotarProdutoQueCabeNaCaixa2() {
        Produto monitor = new Produto("Monitor", new Dimensoes(70, 45, 10));
        Pedido pedido = new Pedido(2, List.of(monitor));

        PedidoResponse resp = embalagemService.embalar(List.of(pedido)).get(0);

        assertEquals(2, resp.getPedidoId());
        CaixaResponse caixa = resp.getCaixas().get(0);
        assertEquals("Caixa 2", caixa.getCaixaId());
        assertTrue(caixa.getProdutos().contains("Monitor"));
        assertNull(caixa.getObservacao());
    }

    @Test
    void deveMarcarObservacaoQuandoProdutoNaoCabeEmNenhumaCaixa() {
        Produto sofa = new Produto("Sofá", new Dimensoes(200,100,90));
        Pedido pedido = new Pedido(3, List.of(sofa));

        PedidoResponse resp = embalagemService.embalar(List.of(pedido)).get(0);
        CaixaResponse caixa = resp.getCaixas().get(0);

        assertNull(caixa.getCaixaId());
        assertNotNull(caixa.getObservacao());
        assertTrue(caixa.getObservacao().toLowerCase().contains("não cabe"));
    }

    @Test
    void deveEmpacotarProdutoNoLimiteExatoDasDimensoesDaCaixa() {
        Produto quadro = new Produto("Quadro", new Dimensoes(50, 80, 60));
        Pedido pedido = new Pedido(4, List.of(quadro));

        CaixaResponse caixa = embalagemService.embalar(List.of(pedido)).get(0).getCaixas().get(0);
        assertEquals("Caixa 3", caixa.getCaixaId());
        assertNull(caixa.getObservacao());
    }

    @Disabled("erro forçado")
    @Test
    void falhaQuandoEscolheCaixaErrada() {
        Produto p = new Produto("Item", new Dimensoes(10,10,10));
        PedidoResponse resp = embalagemService.embalar(List.of(new Pedido(5, List.of(p)))).get(0);
        CaixaResponse caixa = resp.getCaixas().get(0);
        // este assert está errado de propósito
        assertEquals("Caixa 2", caixa.getCaixaId());
    }
}
