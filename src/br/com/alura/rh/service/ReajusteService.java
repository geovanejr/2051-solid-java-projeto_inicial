package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ReajusteService {

    public void ReajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal valorReajuste) {

        BigDecimal salarioAtual = funcionario.getSalario();

        BigDecimal percentualReajuste = valorReajuste.divide(salarioAtual, RoundingMode.HALF_UP);
        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
        }

        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();

        var mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);

        if (mesesDesdeUltimoReajuste < 6) {
            throw new ValidacaoException("Intervalo de meses para reajuste deve ser maior que 5 meses");
        }

        BigDecimal salarioReajustado = salarioAtual.add(valorReajuste);
        funcionario.reajustarSalario(salarioReajustado);
    }
}
