package org.upskill.vencimentos;

/**
 * Representa um trabalhador à comissão através do seu nome, salário base,
 * montante de vendas e percentagem da comissão de vendas.
 *
 * @author Paulo Ferreira
 */
public class TrabalhadorComissao extends Trabalhador {
    /**
     * O salário base do trabalhador à comissão.
     */
    private float salarioBase;

    /**
     * O montante de vendas realizadas pelo trabalhador à comissão.
     */
    private float vendas;

    /**
     * A percentagem da comissão de vendas do trabalhador à comissão.
     */
    private float comissao;

    /**
     * A percentagem do prémio de vendas
     */
    private float premio;

    /**
     * O valor por omissão do salário base do trabalhador à comissão.
     */
    private static final float SALARIO_BASE_POR_OMISSAO = 530;

    /**
     * O montante por omissão das vendas do trabalhador à comissão.
     */
    private static final int VENDAS_POR_OMISSAO = 0;

    /**
     * A percentagem por omissão da comissão de vendas do trabalhador à comissão.
     */
    private static final int COMISSAO_POR_OMISSAO = 0;

    /**
     * A percentagem por omissão do prémio de vendas
     */
    private static final float PREMIO_POR_OMISSAO = 0;

    /**
     * O limite monetário de vendas para ativação do prémio
     */
    private static float limiteVendas = 10000f;

    /**
     * Constrói uma instância de TrabalhadorComissao recebendo o nome, o salário
     * base, o montante de vendas e a percentagem da comissão de vendas do
     * trabalhador à comissão.
     *
     * @param nome        o nome do trabalhador à comissão
     * @param salarioBase o salário base do trabalhador à comissão
     * @param vendas      o montante de vendas do trabalhador à comissão
     * @param comissao    a percentagem da comissão de vendas do trabalhador à comissão
     * @param premio      a percentagem do prémio de vendas do trabalhador à comissão
     */
    public TrabalhadorComissao(String nome, float salarioBase, float vendas,
                               float comissao, float premio) {
        super(nome);
        this.salarioBase = salarioBase;
        this.vendas = vendas;
        this.comissao = comissao;
        this.premio = premio;
    }

    /**
     * Constrói uma instância de TrabalhadorComissao recebendo o nome e
     * atribuindo o salário base por omissão, o montante das vendas por omissão
     * e a percentagem por omissão da comissão de vendas do trabalhador à
     * comissão.
     *
     * @param nome o nome do trabalhador à comissão
     */
    public TrabalhadorComissao(String nome) {
        super(nome);
        salarioBase = SALARIO_BASE_POR_OMISSAO;
        vendas = VENDAS_POR_OMISSAO;
        comissao = COMISSAO_POR_OMISSAO;
        premio = PREMIO_POR_OMISSAO;
    }

    /**
     * Constrói uma instância de TrabalhadorComissao atribuindo o nome por
     * omissão, o salário base por omissão, o montante por omissão das vendas e
     * a percentagem por omissão da comissão de vendas do trabalhador à comissão.
     */
    public TrabalhadorComissao() {
        super();
        salarioBase = SALARIO_BASE_POR_OMISSAO;
        vendas = VENDAS_POR_OMISSAO;
        comissao = COMISSAO_POR_OMISSAO;
        premio = PREMIO_POR_OMISSAO;
    }

    /**
     * Devolve o salário base do trabalhador à comissão.
     *
     * @return salário base do trabalhador à comissão
     */
    public float getSalarioBase() {
        return salarioBase;
    }

    /**
     * Devolve o montante de vendas do trabalhador à comissão.
     *
     * @return montante das vendas do trabalhador à comissão
     */
    public float getVendas() {
        return vendas;
    }

    /**
     * Devolve a percentagem da comissão de vendas do trabalhador à comissão.
     *
     * @return percentagem da comissão de vendas do trabalhador à comissão
     */
    public float getComissao() {
        return comissao;
    }

    /**
     * Devolve a percentagem do prémido sobre as vendas do trabalhador à comissão
     *
     * @return percentagem do prémio sobre as vendas do trabalhador à comissão
     */
    public float getPremio() {
        return this.premio;
    }

    /**
     * Modifica o salário base do trabalhador à comissão.
     *
     * @param salarioBase o novo salário base do trabalhador à comissão
     */
    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    /**
     * Modifica o montante de vendas do trabalhador à comissão.
     *
     * @param vendas o novo montante de vendas do trabalhador à comissão
     */
    public void setVendas(float vendas) {
        this.vendas = vendas;
    }

    /**
     * Modifica a percentagem da comissão de vendas do trabalhador à comissão.
     *
     * @param comissao a nova percentagem da comissão de vendas do trabalhador
     *                 à comissão
     */
    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

    /**
     * Modifica a percentagem do prémio sobre as vendas
     *
     * @param premio a nova percentagem do prémio sobre as vendas
     */
    public void setPremio(float premio) {
        this.premio = premio;
    }

    /**
     * Devolve a descrição textual do trabalhador à comissão.
     *
     * @return caraterísticas do trabalhador à comissão
     */
    @Override
    public String toString() {
        return String.format("Trabalhador à Comissão: %s"
                        + "%nSalário Base: %.2f€"
                        + "%nVendas: %.2f€"
                        + "%nComissão: %.1f%%",
                super.toString(), salarioBase, vendas, comissao);
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (!super.equals(outroObjeto)) {
            return false;
        }
        TrabalhadorComissao tc = (TrabalhadorComissao) outroObjeto;
        return this.salarioBase == tc.salarioBase &&
                this.vendas == tc.vendas &&
                this.comissao == tc.comissao &&
                this.premio == tc.premio;
    }

    /**
     * Devolve o vencimento do trabalhador à comissão.
     *
     * @return vencimento do trabalhador à comissão
     */
    @Override
    public float calcularVencimento() {
        return vendas > limiteVendas ? salarioBase + vendas * (comissao / 100) + (vendas * (premio / 100)) :
                salarioBase + vendas * (comissao / 100);
    }

    /**
     * Devolve o limite de vendas para ativação do bónus
     *
     * @return limite (em €) de vendas para ativação do bónus
     */
    public static float getLimiteVendas() {
        return limiteVendas;
    }

    /**
     * Modifica o limite de vendas (em €) para ativação do bónus
     *
     * @param limiteVendas o novo limite (em €) para ativação do bónus
     */
    public static void setLimiteVendas(float limiteVendas) {
        TrabalhadorComissao.limiteVendas = limiteVendas;
    }
}