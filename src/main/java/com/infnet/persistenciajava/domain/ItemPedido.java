package com.infnet.persistenciajava.domain;

import lombok.Data;

@Data
public class ItemPedido {
    private Double desconto;
    private Integer quantidade;
    private Double preco;
}
