package com.example.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
public class PedidoDTO {
    private Long id;
    private List<String> produtos;
    private String tipoPagamento;
    private String tipoDesconto;
    private double total;
}