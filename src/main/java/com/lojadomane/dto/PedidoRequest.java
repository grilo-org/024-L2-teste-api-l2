package com.lojadomane.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lojadomane.model.Pedido;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PedidoRequest {

    @JsonProperty("pedidos")
    private List<Pedido> pedidos;

    public PedidoRequest() {}

    public PedidoRequest(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
