package br.com.alura.rh.interfaces;

import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;

public interface ValidacaoReajuste {

    void validar(Funcionario funcionario, BigDecimal valorReajuste);
}
