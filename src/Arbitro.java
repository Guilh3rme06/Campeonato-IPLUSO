package src;

/**
 * Classe que representa um árbitro no campeonato.
 */
public class Arbitro extends Pessoa {
    private String certificacoes;

    /**
     * Construtor da classe Arbitro.
     * @param nome Nome do árbitro.
     * @param idade Idade do árbitro.
     * @param genero Gênero do árbitro.
     * @param certificacoes Certificações do árbitro.
     */
    public Arbitro(String nome, int idade, char genero, String certificacoes) {
        super(nome, idade, genero);
        this.certificacoes = certificacoes;
    }
    
    // Getter e Setter
    public String getCertificacoes() {
        return certificacoes;
    }

    public void setCertificacoes(String certificacoes) {
        this.certificacoes = certificacoes;
    }
}