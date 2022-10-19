package com.infnet.persistenciajava.domain;

import lombok.Data;

import java.util.List;

@Data
public class Cliente {
    private Integer id;
    private String nome;
    private String email;
    private String cpfOuCnpj;
    private List<Pedido> pedidos;
    private List<Telefone> telefones;
    private List<Endereco> enderecos;
}
