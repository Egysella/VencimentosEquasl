package org.upskill.vencimentos;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Permite testar o método de cálculo do vencimento para os trabalhadores
 * à comissão
 *
 * @author Paulo Ferreira
 */

class TrabalhadorComissaoTest {

    TrabalhadorComissao tc = new TrabalhadorComissao();

    @org.junit.jupiter.api.Test
    void calcularVencimento() {
        tc.setSalarioBase(1);
        tc.setVendas(1);
        tc.setComissao(5);
        tc.setPremio(5);
        double expResult = 1.05;
        double actResult = tc.calcularVencimento();
        assertEquals(expResult, actResult, 0.001);
    }

    @org.junit.jupiter.api.Test
    void calcularVencimento2() {
        tc.setSalarioBase(1);
        tc.setVendas(10001);
        tc.setComissao(5);
        tc.setPremio(5);
        double expResult = 1001.1;
        double actResult = tc.calcularVencimento();
        assertEquals(expResult, actResult, 0.001);
    }
}