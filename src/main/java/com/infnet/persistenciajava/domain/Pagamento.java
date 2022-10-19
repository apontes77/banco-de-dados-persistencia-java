package com.infnet.persistenciajava.domain;

import com.infnet.persistenciajava.domain.enums.EstadoPagamento;
import lombok.Data;

@Data
public class Pagamento {
    private Integer id;
    private EstadoPagamento estado;
    private Pedido pedido;
}
