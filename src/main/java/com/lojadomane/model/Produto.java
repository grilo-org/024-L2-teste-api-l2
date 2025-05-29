package com.lojadomane.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Produto(@JsonProperty("produto_id") String produtoId, @JsonProperty("dimensoes") Dimensoes dimensoes) {}
