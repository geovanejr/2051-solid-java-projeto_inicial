package br.com.alura.rh.service;

import br.com.alura.rh.interfaces.ValidacaoReajuste;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.util.List;

public class ReajusteService {

    private List<ValidacaoReajuste> validacoes;

    public ReajusteService(List<ValidacaoReajuste> validacoes) {

        this.validacoes = validacoes;
    }

    public void ReajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal valorReajuste) {

        validacoes.forEach(v -> v.validar(funcionario, valorReajuste));

        BigDecimal salarioReajustado = funcionario.getSalario().add(valorReajuste);
        funcionario.reajustarSalario(salarioReajustado);
    }
}
