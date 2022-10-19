package com.infnet.persistenciajava.domain;

import lombok.Data;

import java.util.List;

@Data
public class Produto {
    private Integer id;
    private String nome;
    private Double preco;
    private List<Pedido> pedidos;
    private List<Categoria> categorias;
}
