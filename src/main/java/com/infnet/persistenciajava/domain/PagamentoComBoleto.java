package com.infnet.persistenciajava.domain;

import java.time.LocalDate;

public class PagamentoComBoleto extends Pagamento {
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
}