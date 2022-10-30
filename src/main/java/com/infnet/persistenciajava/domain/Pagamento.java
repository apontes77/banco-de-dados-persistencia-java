package com.infnet.persistenciajava.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.infnet.persistenciajava.domain.enums.EstadoPagamento;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer estado;

    @JsonIgnore
    @JoinColumn(name = "pedido_id")
    @OneToOne
    @MapsId
    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
        super();
        this.id = id;
        this.estado = (estado == null) ? null : estado.getCodigo();
        this.pedido = pedido;
    }
}
