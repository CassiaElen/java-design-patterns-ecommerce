package com.example.observer;

import com.example.model.Pedido;

public class SmsNotificacao implements PedidoObserver {
    public void notificar(Pedido pedido) {
        System.out.println("Enviando SMS: Pedido de R$ " + pedido.getTotal());
    }
}

