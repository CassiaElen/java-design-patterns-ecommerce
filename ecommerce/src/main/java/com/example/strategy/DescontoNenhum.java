package com.example.strategy;

public class DescontoNenhum implements DescontoStrategy {
    public double aplicarDesconto(double total) {
        return total;
    }
}
