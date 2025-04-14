package com.example.factory;

public class PagamentoFactory {
    public static Pagamento criar(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "pix" -> new PagamentoPix();
            case "cartao" -> new PagamentoCartao();
            default -> throw new IllegalArgumentException("Tipo de pagamento inválido");
        };
    }
}
