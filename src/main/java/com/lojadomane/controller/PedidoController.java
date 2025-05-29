package com.lojadomane.controller;

import com.lojadomane.dto.PedidoRequest;
import com.lojadomane.dto.PedidoResponse;
import com.lojadomane.service.EmbalagemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/embalagem")
public class PedidoController {

    private final EmbalagemService embalagemService;

    public PedidoController(EmbalagemService embalagemService) {
        this.embalagemService = embalagemService;
    }

    @PostMapping
    public ResponseEntity<List<PedidoResponse>> embalar(@RequestBody PedidoRequest request) {
        List<PedidoResponse> responses = embalagemService.embalar(request.getPedidos());
        
        return ResponseEntity.ok(responses);
    }
}