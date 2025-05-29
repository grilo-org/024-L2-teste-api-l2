package com.lojadomane.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PedidoResponse {

    @JsonProperty("pedido_id")
    private long pedidoId;

    @JsonProperty("caixas")
    private List<CaixaResponse> caixas;

    public PedidoResponse() {}

    public PedidoResponse(long pedidoId, List<CaixaResponse> caixas) {
        this.pedidoId = pedidoId;
        this.caixas = caixas;
    }

    public long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public List<CaixaResponse> getCaixas() {
        return caixas;
    }

    public void setCaixas(List<CaixaResponse> caixas) {
        this.caixas = caixas;
    }
}
