package com.example.factory;

public class PagamentoCartao implements Pagamento {
    public void processarPagamento(double valor) {
        System.out.println("Pagamento via Cartão: R$ " + valor);
    }
}