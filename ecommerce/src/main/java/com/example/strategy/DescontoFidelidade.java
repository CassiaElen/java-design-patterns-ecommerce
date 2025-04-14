package com.example.strategy;

public class DescontoFidelidade implements DescontoStrategy {
    public double aplicarDesconto(double total) {
        return total * 0.9;
    }
}
