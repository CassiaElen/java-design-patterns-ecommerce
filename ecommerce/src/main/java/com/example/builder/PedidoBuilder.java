package com.example.builder;
import java.util.*;

import com.example.factory.*;
import com.example.model.Pedido;
import com.example.model.Produto;
import com.example.observer.EmailNotificacao;
import com.example.observer.SmsNotificacao;
import com.example.strategy.*;

public class PedidoBuilder {
    private final Pedido pedido = new Pedido();

    public PedidoBuilder comProdutos(List<Produto> produtos) {
        pedido.setProdutos(produtos);
        return this;
    }

    public PedidoBuilder comTipoPagamento(String tipoPagamento) {
        pedido.setTipoPagamento(tipoPagamento);
        return this;
    }

    public PedidoBuilder comTipoDesconto(String tipoDesconto) {
        pedido.setTipoDesconto(tipoDesconto);
        return this;
    }

    public Pedido build() {
        double total = pedido.getProdutos().stream().mapToDouble(Produto::getPreco).sum();

        DescontoStrategy desconto = switch (pedido.getTipoDesconto().toLowerCase()) {
            case "fidelidade" -> new DescontoFidelidade();
            default -> new DescontoNenhum();
        };

        total = desconto.aplicarDesconto(total);
        pedido.setTotal(total);

        Pagamento pagamento = PagamentoFactory.criar(pedido.getTipoPagamento());
        pagamento.processarPagamento(total);

        new EmailNotificacao().notificar(pedido);
        new SmsNotificacao().notificar(pedido);

        return pedido;
    }
}