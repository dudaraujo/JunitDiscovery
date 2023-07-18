package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void BonusDeveriaSerZeroSalarioMaiorQue10000Reais() {
        BonusService service = new BonusService();
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Maria", LocalDate.now(), new BigDecimal("25000"))));

        //assertEquals(BigDecimal.ZERO, bonus);

    }

    @Test
    void ExceptionBonusDeveriaSerZeroSalarioMaiorQue10000Reais() {
        BonusService service = new BonusService();

        try {
           service.calcularBonus(new Funcionario("Maria", LocalDate.now(), new BigDecimal("25000")));
            fail("Não deu a exception");
        } catch (Exception e) {
            assertEquals("Funcionário com salário maior do que R$10.0000 não pode receber bônus", e.getMessage());
        }

    }

    @Test
    void BonusDeveriaSer10PorCentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service
            .calcularBonus(new Funcionario("Luis", LocalDate.now(), new BigDecimal("2600")));

        assertEquals(new BigDecimal("260.00"), bonus);
    }

    @Test
    void BonusDeveriaSer10PorCentoParaSalarioDe10000Reais () {
        BonusService service = new BonusService();
        BigDecimal bonus = service
            .calcularBonus(new Funcionario("Felipe", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);

    }



}
