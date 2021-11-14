package br.com.alura.rh.app;

import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.service.PromocaoService;
import br.com.alura.rh.service.ReajusteService;

import java.math.BigDecimal;

public class TesteRH {

    public static void main(String[] args) {

        PromocaoService promocaoService = new PromocaoService();

        System.out.println("Iniciando Testes");

        Funcionario f1 = new Funcionario("Geovane", "12345678909", Cargo.ANALISTA, new BigDecimal(2000));
        System.out.println(f1);

        promocaoService.promover(f1, true);
        System.out.println(f1);
        promocaoService.promover(f1, true);
        System.out.println(f1);
    }
}
