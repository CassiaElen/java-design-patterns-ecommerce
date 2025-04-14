package com.example.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.builder.PedidoBuilder;
import com.example.dto.*;
import com.example.model.*;
import com.example.repository.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final ProdutoRepository produtoRepository;
    private final PedidoRepository pedidoRepository;

    public PedidoDTO criarPedido(CriarPedidoRequest request) {
        List<Produto> produtos = produtoRepository.findAllById(request.getProdutos());

        Pedido pedido = new PedidoBuilder()
                .comProdutos(produtos)
                .comTipoPagamento(request.getTipoPagamento())
                .comTipoDesconto(request.getTipoDesconto())
                .build();

        pedido = pedidoRepository.save(pedido);

        return toDTO(pedido);
    }

    public List<PedidoDTO> listarTodos() {
        return pedidoRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<PedidoDTO> buscarPorId(Long id) {
        return pedidoRepository.findById(id).map(this::toDTO);
    }

    private PedidoDTO toDTO(Pedido pedido) {
        List<String> nomes = pedido.getProdutos().stream().map(Produto::getNome).toList();
        return new PedidoDTO(
                pedido.getId(),
                nomes,
                pedido.getTipoPagamento(),
                pedido.getTipoDesconto(),
                pedido.getTotal()
        );
    }
}
