package src;

/**
 * Classe que representa um jogador no campeonato.
 */
public class Jogador extends Pessoa {
    private int rankings;
    private int partidasJogadas;

    /**
     * Construtor da classe Jogador.
     * @param nome Nome do jogador.
     * @param idade Idade do jogador.
     * @param genero Gênero do jogador.     
     * @param ranking Ranking do jogador.
     * @param partidasJogadas Número de partidas jogadas pelo jogador.
     */
    public Jogador(String nome, int idade, char genero, int rankings, int partidasJogadas) {
        super(nome, idade, genero);
        this.rankings = rankings;
        this.partidasJogadas = partidasJogadas;
    }
    
    // Getters e Setters
    public int getRankings() {
        return rankings;
    }

    public int getPartidasJogadas() {
        return partidasJogadas;
    }

    public void setRankings(int rankings) {
        this.rankings = rankings;
    }

    public void setPartidasJogadas(int partidasJogadas) {
        this.partidasJogadas = partidasJogadas;
    }
}