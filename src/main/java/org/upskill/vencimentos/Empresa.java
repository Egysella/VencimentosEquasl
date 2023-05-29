package org.upskill.vencimentos;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Representa uma empresa através do seu nome e morada
 *
 * @author Paulo Ferreira
 * */

public class Empresa {

    /**
     * Armazena o nome da empresa
     */
    private String nome;

    /**
     * Armazena a morada da empresa
     */
    private String morada;

    /**
     * Contentor que armazena os trabalhadores
     */
    private List<Trabalhador> trabalhadores;

    /**
     * Nome da empresa por omissão
     */
    private static final String NOME_POR_OMISSAO = "Sem nome";

    /**
     * Morada da empresa por omissão
     */
    private static final String MORADA_POR_OMISSAO = "Sem morada";

    /**
     * Construtor com todos os parâmetros
     *
     * @param nome   o nome da empresa
     * @param morada a morada da empresa
     */
    public Empresa(String nome, String morada, List<Trabalhador> trabalhadores) {
        this.morada = morada;
        this.nome = nome;
        this.trabalhadores =  trabalhadores;

    }

    /**
     * Construtor sem parâmetros
     */
    public Empresa() {
        this.morada = MORADA_POR_OMISSAO;
        this.nome = NOME_POR_OMISSAO;
        this.trabalhadores =  new ArrayList<>();
    }

    /**
     * Construtor com 2 parâmetros
     *
     * @param nome o nome da empresa
     * @param morada a morada da empresa
     * */
    public Empresa(String nome, String morada) {
        this.morada = morada;
        this.nome = nome;
        this.trabalhadores =  new ArrayList<>();
    }

    /**
     * Devolve o nome da empresa
     *
     * @return o nome da empresa
     */
    public String getNome() {
        return nome;
    }

    /**
     * Devolve a morada da empresa
     *
     * @return a morada da empresa
     */
    public String getMorada() {
        return morada;
    }

    /**
     * Devolve a lista de trabalhadores
     */
    public List<Trabalhador> getTrabalhadores() {
        return this.trabalhadores;
    }

    /**
     * Altera o nome da empresa
     *
     * @param nome o novo nome da empresa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Altera a morada da empresa
     *
     * @param morada a nova morada da empresa
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * Método que altera o conteúdo da lista trabalhadores
     *
     * @param lista uma lista de trabalhadores
     * */
    public void setTrabalhadores(List<Trabalhador> lista){
        this.trabalhadores = lista;
    }

    /**
     * Representação textual da classe Empresa
     *
     * @return o nome e morada da empresa
     */
    @Override
    public String toString() {
        return String.format("Empresa: %s\nMorada: %s\nTrabalhadores: %s", nome, morada, trabalhadores);
    }

    /**
     * Método para adicionar trabalhadores à empresa
     */
    public void adicionarTrabalhador(Trabalhador novoTrabalhador) {
        if (!trabalhadores.contains(novoTrabalhador)){
            trabalhadores.add(novoTrabalhador);
        }
    }

    /*
     * Método que lista os trabalhadores por ordem crescrente do vencimento
     * e, caso existam trabalhadores como o mesmo vencimento, apresenta os
     * seus nomes por ordem alfabética
     */
    public void mostrarTrabalhadores() {
        // Collections.sort(trabalhadores, Comparator.comparing(Trabalhador::calcularVencimento).thenComparing(Trabalhador::getNome))
        OrdemAscendente ordem = new OrdemAscendente();
        Collections.sort(trabalhadores, ordem);
//        Collections.sort(trabalhadores, new OrdemAscendente());
        listarTrabs();
    }

    /**
     * Devolve o vencimento acumulado de todos os trabalhadores da empresa
     *
     * @return o vencimento acumulado dos trabalhadores da empresa
     */
    public double vencimentoAcumulado() {
        double acumulado = 0;
        for (Trabalhador trab : trabalhadores) {
            if (trab != null) {
                acumulado += trab.calcularVencimento();
            }
        }
        return acumulado;
    }

    /**
     * Método para listar trabalhadores e o seu vencimento
     * */
    private void listarTrabs(){
        for (Trabalhador trab : trabalhadores) {
            if (trab != null) {
                System.out.printf("%n%s%nSalário: %.2f€%n", trab, trab.calcularVencimento());
            }
        }
    }
}

