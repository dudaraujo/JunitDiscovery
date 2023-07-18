package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void Iniciar() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Duda", LocalDate.now(), new BigDecimal("2600"));
    }


    @Test
    void ReajusteDeveriaSerIgualA3PorCentoDoSalarioParaDesempenhoADesejar() {

        service.CalcularReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("2678.00"), funcionario.getSalario());

    }

    @Test
    void ReajusteDeveriaSerIgualA15PorCentoDoSalarioParaDesempenhoBom() {

        service.CalcularReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("2990.00"), funcionario.getSalario());

    }

    @Test
    void ReajusteDeveriaSerIgualA20PorCentoDoSalarioParaDesempenhoOtimo() {

        service.CalcularReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("3120.00"), funcionario.getSalario());

    }
}
