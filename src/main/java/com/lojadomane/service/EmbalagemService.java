package com.lojadomane.service;

import com.lojadomane.model.Caixa;
import com.lojadomane.model.Dimensoes;
import com.lojadomane.model.Produto;
import com.lojadomane.model.Pedido;
import com.lojadomane.dto.CaixaResponse;
import com.lojadomane.dto.PedidoResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Service
public class EmbalagemService {

    public List<PedidoResponse> embalar(List<Pedido> pedidos) {
        List<PedidoResponse> respostas = new ArrayList<>();

        List<Caixa> caixas = new ArrayList<>(Caixa.lstCaixas());
        caixas.sort(Comparator.comparingInt(c -> volume(c.dimensoes())));

        for (Pedido pedido : pedidos) {
            List<CaixaResponse> alocacoes = new ArrayList<>();
            List<Produto> sobraram = new ArrayList<>(pedido.produtos());

            while (!sobraram.isEmpty()) {
                boolean encaixouAlguem = false;

                for (Caixa caixa : caixas) {
                    List<String> itensNaCaixa = new ArrayList<>();
                    Iterator<Produto> it = sobraram.iterator();

                    while (it.hasNext()) {
                        Produto produto = it.next();
                        if (cabeNaCaixa(produto.dimensoes(), caixa.dimensoes())) {
                            itensNaCaixa.add(produto.produtoId());
                            it.remove();
                        }
                    }

                    if (!itensNaCaixa.isEmpty()) {
                        alocacoes.add(new CaixaResponse(caixa.caixaId(), itensNaCaixa, null));
                        encaixouAlguem = true;
                        break;
                    }
                }

                if (!encaixouAlguem) {
                    List<String> falharam = new ArrayList<>();
                    for (Produto p : sobraram) falharam.add(p.produtoId());
                    alocacoes.add(new CaixaResponse(null, falharam,
                            "Produto não cabe em nenhuma caixa disponível!"));
                    break;
                }
            }

            respostas.add(new PedidoResponse(pedido.pedidoId(), alocacoes));
        }

        return respostas;
    }

    private boolean cabeNaCaixa(Dimensoes produto, Dimensoes caixa) {
        int[] pd = {produto.altura(), produto.largura(), produto.comprimento()};
        int[] cd = {caixa.altura(), caixa.largura(), caixa.comprimento()};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == i) continue;
                int k = 3 - i - j;
                if (pd[i] <= cd[0] && pd[j] <= cd[1] && pd[k] <= cd[2]) {
                    return true;
                }
            }
        }
        return false;
    }

    private int volume(Dimensoes d) {
        return d.altura() * d.largura() * d.comprimento();
    }
}