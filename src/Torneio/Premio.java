

/**
 * Classe que representa um prêmio no campeonato.
 */
public class Premio {
    private String tipo;
    private double valor;

    /**
     * Construtor da classe Premio.
     * @param tipo Tipo do prêmio.
     * @param valor Valor do prêmio.
     */
    public Premio(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    /**
     * Obtem o tipo do prêmio.
     * @return Tipo do prêmio.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo do prêmio.
     * @param tipo Tipo do prêmio.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtem o valor do prêmio.
     * @return Valor do prêmio.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Define o valor do prêmio.
     * @param valor Valor do prêmio.
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Define o prêmio para torneios de singulares.
     */
    public void definirPremioSingulares() {
        this.tipo = "Singulares";
        this.valor = 30000;
    }

    /**
     * Define o prêmio para torneios de duplas.
     */
    public void definirPremioDuplas() {
        this.tipo = "Duplas";
        this.valor = 40000;
    }
}