package com.example.dto;

import lombok.Data;

import java.util.List;

@Data
public class CriarPedidoRequest {
    private List<Long> produtos;
    private String tipoPagamento;
    private String tipoDesconto;
}
