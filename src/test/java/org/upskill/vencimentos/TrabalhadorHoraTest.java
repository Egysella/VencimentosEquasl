package org.upskill.vencimentos;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Permite testar o método de cálculo do vencimento para os trabalhadores
 * à comissão
 *
 * @author Paulo Ferreira
 */

class TrabalhadorHoraTest {

    TrabalhadorHora th = new TrabalhadorHora();

    @org.junit.jupiter.api.Test
    void calcularVencimento() {
        th.setNumeroHoras(1);
        th.setPagamentoHora(1);
        double expResult = 1;
        double actResult = th.calcularVencimento();
        assertEquals(expResult, actResult, 0.001);
    }
}