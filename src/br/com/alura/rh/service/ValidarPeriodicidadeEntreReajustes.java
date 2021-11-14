package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.interfaces.ValidacaoReajuste;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidarPeriodicidadeEntreReajustes implements ValidacaoReajuste {

    public void validar(Funcionario funcionario, BigDecimal valorReajuste) {

        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();

        var mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);

        if (mesesDesdeUltimoReajuste < 6) {
            throw new ValidacaoException("Intervalo de meses para reajuste deve ser maior que 5 meses");
        }
    }
}
