package com.infnet.persistenciajava.domain;

import lombok.Data;

@Data
public class Cidade {
    private Integer id;
    private String nome;
    private Estado estado;
}
