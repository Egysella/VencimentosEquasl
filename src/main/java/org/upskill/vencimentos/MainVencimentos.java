package org.upskill.vencimentos;

import java.util.List;

public class MainVencimentos {

    public static void main(String[] args) {
        TrabalhadorComissao tc = new TrabalhadorComissao("Susana Ferreira", 500.0f, 1500.0f, 6f, 0f);
        TrabalhadorComissao tc2 = new TrabalhadorComissao("Bruno Magalhães", 500.0f, 1500.0f, 6f, 0f);
        TrabalhadorPeca tp = new TrabalhadorPeca("Jorge Silva", 500, 499);
        TrabalhadorHora th = new TrabalhadorHora("Carlos Miguel", 160, 3.5f);
        TrabalhadorPeca tp2 = new TrabalhadorPeca("Maria Miguel", 500, 500);
        TrabalhadorHora th2 = new TrabalhadorHora("Joana Santos", 1600, 3.5f);

        /// Instância Empresa
        Empresa emp = new Empresa("IT", "Coimbra");

        /// Armazena os trabalhadores na instância Empresa
        emp.adicionarTrabalhador(tc);
        emp.adicionarTrabalhador(tp);
        emp.adicionarTrabalhador(th);
        emp.adicionarTrabalhador(tc2);
        emp.adicionarTrabalhador(tp2);
        emp.adicionarTrabalhador(th2);
        emp.adicionarTrabalhador(th2); //Unit test

        // Listagens separadas para cada tipo de trabalhador
        List<Trabalhador> trabs = emp.getTrabalhadores();

        //Listagem trabalhadores à Comissão
        System.out.println("### Trabalhadores à Comissão ###");
        double totalVencimentoTC = 0;
        for (Trabalhador trab : trabs) {
            if (trab instanceof TrabalhadorComissao) {
                totalVencimentoTC += trab.calcularVencimento();
                System.out.printf("%n%s%nSalário: %.2f€%n", trab, trab.calcularVencimento());
            }
        }
        System.out.printf("%nSalário Acumulado Trabalhadores à Comissão: %.2f€\n", totalVencimentoTC);

        //Listagem trabalhadores à Peça
        System.out.println("\n### Trabalhadores à Peça ###");
        double totalVencimentoTP = 0;
        for (Trabalhador trab : trabs) {
            if (trab instanceof TrabalhadorPeca) {
                totalVencimentoTP += trab.calcularVencimento();
                System.out.printf("%n%s%nSalário: %.2f€%n", trab, trab.calcularVencimento());
            }
        }
        System.out.printf("%nSalário Acumulado Trabalhadores à Peca: %.2f€\n", totalVencimentoTP);

        //Listagem trabalhadores à Hora
        System.out.println("\n### Trabalhadores à Peça ###");
        double totalVencimentoTH = 0;
        for (Trabalhador trab : trabs) {
            if (trab instanceof TrabalhadorHora) {
                totalVencimentoTH += trab.calcularVencimento();
                System.out.printf("%n%s%nSalário: %.2f€%n", trab, trab.calcularVencimento());
            }
        }
        System.out.printf("%nSalário Acumulado Trabalhadores à Hora: %.2f€\n", totalVencimentoTH);

        // Trabalhadores da Empresa listados por ordem crescrente de salário e, caso necessário,
        // ordem alfabética
        System.out.println("\n### Lista de Trabalhadores da Empresa ###");
        emp.mostrarTrabalhadores();

        //Vencimento acumulado de todos os trabalhadores da empresa
        System.out.println("\n### Vencimento acumulado dos trabalhadores da empresa");
        System.out.printf("\nVencimento Acumulado: %.2f€", emp.vencimentoAcumulado());

    }
}