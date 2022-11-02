package com.infnet.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.infnet.domain.enums.EstadoPagamento;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
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
