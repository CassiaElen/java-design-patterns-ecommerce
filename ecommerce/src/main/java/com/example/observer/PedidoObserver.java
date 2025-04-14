package com.example.observer;

import com.example.model.Pedido;

public interface PedidoObserver {
    void notificar(Pedido pedido);
}