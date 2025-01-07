package src;

import java.util.Random;

/**
 * Classe que representa uma partida de duplas.
 */
public class PartidaDuplas implements ControloPartida {
    private Jogador jogador1Eq1;
    private Jogador jogador2Eq1;
    private Jogador jogador1Eq2;
    private Jogador jogador2Eq2;
    private Arbitro arbitro;
    private String resultado;

    /**
     * Construtor da classe PartidaDuplas.
     * @param jogador1Eq1 Primeiro jogador da primeira equipe.
     * @param jogador2Eq1 Segundo jogador da primeira equipe.
     * @param jogador1Eq2 Primeiro jogador da segunda equipe.
     * @param jogador2Eq2 Segundo jogador da segunda equipe.
     * @param arbitro Árbitro da partida.
     * @param resultado Resultado da partida.
     */
    public PartidaDuplas(Jogador jogador1Eq1, Jogador jogador2Eq1, Jogador jogador1Eq2, Jogador jogador2Eq2,
        Arbitro arbitro, String resultado) {
        this.jogador1Eq1 = jogador1Eq1;
        this.jogador2Eq1 = jogador2Eq1;
        this.jogador1Eq2 = jogador1Eq2;
        this.jogador2Eq2 = jogador2Eq2;
        this.arbitro = arbitro;
        this.resultado = resultado;
    }

    /**
     * Obtém o primeiro jogador da primeira equipe.
     * @return Primeiro jogador da primeira equipe.
     */
    public Jogador getJogador1Eq1() {
        return jogador1Eq1;
    }

    /**
     * Obtém o primeiro jogador da segunda equipe.
     * @return Primeiro jogador da segunda equipe.
     */
    public Jogador getJogador1Eq2() {
        return jogador1Eq2;
    }

    /**
     * Obtém o segundo jogador da primeira equipe.
     * @return Segundo jogador da primeira equipe.
     */
    public Jogador getJogador2Eq1() {
        return jogador2Eq1;
    }

    /**
     * Obtém o segundo jogador da segunda equipe.
     * @return Segundo jogador da segunda equipe.
     */
    public Jogador getJogador2Eq2() {
        return jogador2Eq2;
    }

    /**
     * Obtém o árbitro da partida.
     * @return Árbitro da partida.
     */
    public Arbitro getArbitro() {
        return arbitro;
    }

    /**
     * Obtém o resultado da partida.
     * @return Resultado da partida.
     */
    public String getResultado() {
        return resultado;
    }

    @Override
    public String aplicarRegras() {
        return "Regras";
    }

    /**
     * Determina o vencedor da partida de duplas e atualiza os rankings dos jogadores vencedores.
     * @return Jogador vencedor da equipe vencedora.
     */
    @Override
    public Jogador determinarVencedor() {
        this.jogador1Eq1.setPartidasJogadas(jogador1Eq1.getPartidasJogadas() + 1);
        this.jogador2Eq1.setPartidasJogadas(jogador2Eq1.getPartidasJogadas() + 1);
        this.jogador1Eq2.setPartidasJogadas(jogador1Eq2.getPartidasJogadas() + 1);
        this.jogador2Eq2.setPartidasJogadas(jogador2Eq2.getPartidasJogadas() + 1);

        Random vencedorPartidaDuplas = new Random();
        int vencedor = vencedorPartidaDuplas.nextInt(2) + 1;

        if (vencedor == 1) {
            System.out.println("O vencedor da Partida Duplas é: " + this.jogador1Eq1.getNome() + " e "
                    + this.jogador2Eq1.getNome());
            this.jogador1Eq1.setRankings(jogador1Eq1.getRankings() + 3);
            this.jogador2Eq1.setRankings(jogador2Eq1.getRankings() + 3);
            return this.jogador1Eq1;
        } else {
            System.out.println("O vencedor da Partida Duplas é: " + this.jogador1Eq2.getNome() + " e "
                    + this.jogador2Eq2.getNome());
            this.jogador1Eq2.setRankings(jogador1Eq2.getRankings() + 3);
            this.jogador2Eq2.setRankings(jogador2Eq2.getRankings() + 3);
            return this.jogador1Eq2;
        }
    }

    /**
     * Obtém o tempo da partida de duplas.
     * @return Tempo da partida de duplas.
     */
    @Override
    public double tempoPartida() {
        return 40.0;
    }
}