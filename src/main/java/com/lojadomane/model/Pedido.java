package com.lojadomane.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record Pedido(@JsonProperty("pedido_id") int pedidoId, @JsonProperty("produtos") List<Produto> produtos) {}
