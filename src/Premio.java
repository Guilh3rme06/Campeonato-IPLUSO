package src;

/**
 * Classe que representa um premio no campeonato.
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

    // Getters e Setters
    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
