package com.lojadomane.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Dimensoes(
    @JsonProperty("altura") int altura,
    @JsonProperty("largura") int largura,
    @JsonProperty("comprimento") int comprimento
) {}
