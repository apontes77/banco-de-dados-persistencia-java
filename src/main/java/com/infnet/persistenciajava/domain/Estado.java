package com.infnet.persistenciajava.domain;

import lombok.Data;

import java.util.List;

@Data
public class Estado {
    private Integer id;
    private String nome;
    private List<Cidade> cidades;
}
