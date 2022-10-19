package com.infnet.persistenciajava.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Pedido {
    private Long id;
    private LocalDateTime instante;
    private Pagamento pagamento;
    private Cliente cliente;
    private Endereco enderecoDeEntrega;
    private List<Produto> itens;
}
