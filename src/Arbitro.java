package src;

/**
 * Classe que representa um árbitro no campeonato.
 */
public class Arbitro extends Pessoa {
    private int id;
    private String certificacoes;

    /**
     * Construtor da classe Arbitro.
     * @param nome Nome do árbitro.
     * @param idade Idade do árbitro.
     * @param genero Gênero do árbitro.
     * @param id ID do árbitro.
     * @param certificacoes Certificações do árbitro.
     */
    public Arbitro(String nome, int idade, char genero, int id, String certificacoes) {
        super(nome, idade, genero);
        this.id = id;
        this.certificacoes = certificacoes;
    }

    /**
     * Obtém o ID do árbitro.
     * @return ID do árbitro.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do árbitro.
     * @param id ID do árbitro.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém as certificações do árbitro.
     * @return Certificações do árbitro.
     */
    public String getCertificacoes() {
        return certificacoes;
    }

    /**
     * Define as certificações do árbitro.
     * @param certificacoes Certificações do árbitro.
     */
    public void setCertificacoes(String certificacoes) {
        this.certificacoes = certificacoes;
    }
}