package com.example.observer;

import com.example.model.Pedido;

public class EmailNotificacao implements PedidoObserver {
    public void notificar(Pedido pedido) {
        System.out.println("Enviando e-mail: Pedido de R$ " + pedido.getTotal());
    }
}
