package src;

import java.util.Random;

public class PartidaDuplas {
    private Jogador jogador1Eq1;
    private Jogador jogador2Eq1;
    private Jogador jogador1Eq2;
    private Jogador jogador2Eq2;
    private Arbitro arbitro;
    private String resultado;

    public PartidaDuplas(Jogador jogador1Eq1, Jogador jogador2Eq1, Jogador jogador1Eq2, Jogador jogador2Eq2, Arbitro arbitro) {
        this.jogador1Eq1 = jogador1Eq1;
        this.jogador2Eq1 = jogador2Eq1;
        this.jogador1Eq2 = jogador1Eq2;
        this.jogador2Eq2 = jogador2Eq2;
        this.arbitro = arbitro;
    }

    public Jogador getJogador1Eq1() {
        return jogador1Eq1;
    }

    public Jogador getJogador2Eq1() {
        return jogador2Eq1;
    }

    public Jogador getJogador1Eq2() {
        return jogador1Eq2;
    }

    public Jogador getJogador2Eq2() {
        return jogador2Eq2;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public String getResultado() {
        return resultado;
    }

    public Jogador[] determinarVencedores() {
        Random vencedorPartidaDuplas = new Random();
        int vencedor = vencedorPartidaDuplas.nextInt(2) + 1;

        if (vencedor == 1) {
            resultado = "Os Vencedores da Partida Duplas são: " + jogador1Eq1.getNome() + " e " + jogador2Eq1.getNome();
            this.jogador1Eq1.setRankings(jogador1Eq1.getRankings() + 3);
            this.jogador2Eq1.setRankings(jogador2Eq1.getRankings() + 3);
            return new Jogador[]{jogador1Eq1, jogador2Eq1};
        } else {
            resultado = "Os Vencedores da Partida Duplas são: " + jogador1Eq2.getNome() + " e " + jogador2Eq2.getNome();
            this.jogador1Eq2.setRankings(jogador1Eq2.getRankings() + 3);
            this.jogador2Eq2.setRankings(jogador2Eq2.getRankings() + 3);
            return new Jogador[]{jogador1Eq2, jogador2Eq2};
        }
    }

    /**
     * Obtém o tempo da partida de duplas.
     * @return Tempo da partida de duplas.
     */
    public double tempoPartida() {
        return 40.0;
    }
}