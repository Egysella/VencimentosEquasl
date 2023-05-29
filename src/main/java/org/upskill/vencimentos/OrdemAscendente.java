package org.upskill.vencimentos;
import java.util.Comparator;

/**
 * Implementação do 'interface' Comparator
 * para ordenar trabalhadores por ordem ascendente de salário e,
 * caso haja salários iguais, ordenar por ordem alfabética.
 *
 * @author Paulo Ferreira
 * */

public class OrdemAscendente implements Comparator {
    public int compare(Object f1, Object f2) {
        double vencimento1 = ((Trabalhador) f1).calcularVencimento();
        double vencimento2 = ((Trabalhador) f2).calcularVencimento();

        if (vencimento1 < vencimento2)
            return -1;
        else if (vencimento1 > vencimento2)
            return 1;
        else
            return ((Trabalhador) f1).getNome().compareTo(((Trabalhador) f2).getNome());
    }
}
