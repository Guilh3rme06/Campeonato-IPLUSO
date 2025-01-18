package Partidas;

import java.util.Random;

import Participantes.*;

/**
 * Classe que representa uma partida de duplas.
 */
public class PartidaDuplas implements ControloPartidaDuplas {
    private Jogador[] dupla1;
    private Jogador[] dupla2;
    private Arbitro arbitro;
    private String resultado;

    /**
     * Construtor para inicializar uma partida de duplas.
     *
     * @param dupla1 Array de jogadores da primeira dupla.
     * @param dupla2 Array de jogadores da segunda dupla.
     * @param arbitro Arbitro responsavel pela partida.
     */
    public PartidaDuplas(Jogador[] dupla1, Jogador[] dupla2, Arbitro arbitro) {
        this.dupla1 = dupla1;
        this.dupla2 = dupla2;
        this.arbitro = arbitro;
    }

    /**
     * Obtem a primeira dupla de jogadores.
     *
     * @return Array de jogadores da primeira dupla.
     */
    public Jogador[] getDupla1() {
        return dupla1;
    }

    /**
     * Obtem a segunda dupla de jogadores.
     *
     * @return Array de jogadores da segunda dupla.
     */
    public Jogador[] getDupla2() {
        return dupla2;
    }

    /**
     * Obtem o arbitro responsavel pela partida.
     *
     * @return Arbitro da partida.
     */
    public Arbitro getArbitro() {
        return arbitro;
    }

    /**
     * Obtem o resultado da partida.
     *
     * @return Resultado da partida.
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Aplica as regras da partida de duplas.
     *
     * @return String representando as regras aplicadas.
     */
    @Override
    public String aplicarRegras() {
        return "Regras";
    }

    /**
     * Determina os vencedores da partida de duplas.
     *
     * @return Array de jogadores vencedores.
     */
    @Override
    public Jogador[] determinarVencedores() {
        for (Jogador jogador : dupla1) {
            jogador.setPartidasJogadas(jogador.getPartidasJogadas() + 1);
        }
        for (Jogador jogador : dupla2) {
            jogador.setPartidasJogadas(jogador.getPartidasJogadas() + 1);
        }

        Random vencedorPartidaDuplas = new Random();
        int vencedor = vencedorPartidaDuplas.nextInt(2);

        if (vencedor == 0) {
            System.out.println("Os vencedores da Partida Duplas sãa: " + dupla1[0].getNome() + " e " + dupla1[1].getNome());
            for (Jogador jogador : dupla1) {
                jogador.setRankings(jogador.getRankings() + 5);
            }
            return dupla1;
        } else {
            System.out.println("Os vencedores da Partida Duplas sao: " + dupla2[0].getNome() + " e " + dupla2[1].getNome());
            for (Jogador jogador : dupla2) {
                jogador.setRankings(jogador.getRankings() + 5);
            }
            return dupla2;
        }
    }

    /**
     * Obtem o tempo da partida de duplas.
     *
     * @return Tempo da partida em minutos.
     */
    @Override
    public double tempoPartida() {
        return 40.0;
    }
}