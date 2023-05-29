package org.upskill.vencimentos;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Permite testar o método de cálculo do vencimento para os trabalhadores
 * à comissão
 *
 * @author Paulo Ferreira
 */

class TrabalhadorPecaTest {

    TrabalhadorPeca tp = new TrabalhadorPeca();

    @org.junit.jupiter.api.Test
    void calcularVencimento() {
        tp.setNumeroPecasTipo1(1);
        tp.setNumeroPecasTipo2(1);
        TrabalhadorPeca.setPagamentoPecaTipo1(1);
        TrabalhadorPeca.setPagamentoPecaTipo2(1);
        double expResult = 2;
        double actResult = tp.calcularVencimento();
        assertEquals(expResult, actResult, 0.001);
    }

    @org.junit.jupiter.api.Test
    void calcularVencimento2() {
        tp.setNumeroPecasTipo1(500);
        tp.setNumeroPecasTipo2(500);
        TrabalhadorPeca.setPagamentoPecaTipo1(1);
        TrabalhadorPeca.setPagamentoPecaTipo2(1);
        TrabalhadorPeca.setNumPecasBonus(1000);
        TrabalhadorPeca.setBonusRendimento(0.05f);
        double expResult = 1050;
        double actResult = tp.calcularVencimento();
        assertEquals(expResult, actResult, 0.001);
    }
}