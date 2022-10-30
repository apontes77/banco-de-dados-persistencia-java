package com.infnet.persistenciajava.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.infnet.persistenciajava.domain.enums.EstadoPagamento;

import javax.persistence.Entity;
import java.time.LocalDate;
@Entity
public class PagamentoComBoleto extends Pagamento {
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVencimento;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPagamento;

    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, LocalDate dataVencimento,
                              LocalDate dataPagamento) {
        super(id, estado, pedido);
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;

    }
}
