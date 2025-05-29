package com.lojadomane.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CaixaResponse {
    @JsonProperty("caixa_id")
    private String caixaId;

    @JsonProperty("produtos")
    private List<String> produtos;

    @JsonProperty("observacao")
    private String observacao;

    public CaixaResponse() {}

    public CaixaResponse(String caixaId, List<String> produtos, String observacao) {
        this.caixaId = caixaId;
        this.produtos = produtos;
        this.observacao = observacao;
    }

    public String getCaixaId() {
        return caixaId;
    }

    public void setCaixaId(String caixaId) {
        this.caixaId = caixaId;
    }

    public List<String> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<String> produtos) {
        this.produtos = produtos;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
