import java.util.ArrayList;

/**
 * Classe que representa um jogador no campeonato.
 */
public class Jogador extends Pessoa {
    private int rankings;
    private int partidasJogadas;
    private static ArrayList<Jogador> jogadores = new ArrayList<>();


    /**
     * Construtor da classe Jogador.
     * @param nome Nome do jogador.
     * @param idade Idade do jogador.
     * @param genero Gênero do jogador.
     * @param rankings Ranking do jogador.
     * @param partidasJogadas Número de partidas jogadas pelo jogador.
     */
    public Jogador(String nome, int idade, char genero, int rankings, int partidasJogadas) {
        super(nome, idade, genero);
        this.rankings = rankings;
        this.partidasJogadas = partidasJogadas;
    }

    /**
     * Obtém o ranking do jogador.
     * @return Ranking do jogador.
     */
    public int getRankings() {
        return rankings;
    }

    /**
     * Define o ranking do jogador.
     * @param rankings Ranking do jogador.
     */
    public void setRankings(int rankings) {
        this.rankings = rankings;
    }

    /**
     * Obtém o número de partidas jogadas pelo jogador.
     * @return Número de partidas jogadas pelo jogador.
     */
    public int getPartidasJogadas() {
        return partidasJogadas;
    }

    /**
     * Define o número de partidas jogadas pelo jogador.
     * @param partidasJogadas Número de partidas jogadas pelo jogador.
     */
    public void setPartidasJogadas(int partidasJogadas) {
        this.partidasJogadas = partidasJogadas;
    }

    public static void adicionarJogador(Jogador jogador){
        jogadores.add(jogador);
    }
}