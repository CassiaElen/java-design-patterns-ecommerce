package com.example.factory;

public class PagamentoPix implements Pagamento {
    public void processarPagamento(double valor) {
        System.out.println("Pagamento via Pix: R$ " + valor);
    }
}
