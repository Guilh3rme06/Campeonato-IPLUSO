import java.util.ArrayList;
/**
 * Classe que representa um árbitro no campeonato.
 */
public class Arbitro extends Pessoa {
    private String certificacoes;
    private static ArrayList<Arbitro> arbitros = new ArrayList<>();

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

    public static void adicionarArbitro(Arbitro arbitro){
        arbitros.add(arbitro);
    }

    public String toString(){
        return"Arbitro: " +
                "Nome= " + getNome() +
                ", Idade= " + getIdade() +
                ", Género= " + getGenero() +
                ", Certificações= " + certificacoes;
    }
}