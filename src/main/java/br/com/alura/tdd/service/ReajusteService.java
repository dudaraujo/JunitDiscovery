package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void CalcularReajuste(Funcionario funcionario, Desempenho desempenho) {

            BigDecimal percentual = desempenho.PercentualReajuste();

            BigDecimal reajuste = funcionario.getSalario().multiply(percentual);

            funcionario.ReajustarSalario(reajuste);


    }
}
