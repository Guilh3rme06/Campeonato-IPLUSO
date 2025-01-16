package src;

import java.util.Random;

public class PartidaDuplas implements ControloPartidaDuplas {
    private Jogador[] dupla1;
    private Jogador[] dupla2;
    private Arbitro arbitro;
    private String resultado;

    // Construtor
    public PartidaDuplas(Jogador[] dupla1, Jogador[] dupla2, Arbitro arbitro) {
        this.dupla1 = dupla1;
        this.dupla2 = dupla2;
        this.arbitro = arbitro;
    }

    // Getters
    public Jogador[] getDupla1() {
        return dupla1;
    }

    public Jogador[] getDupla2() {
        return dupla2;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public String getResultado() {
        return resultado;
    }

    @Override
    public String aplicarRegras() {
        return "Regras";
    }

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
            System.out.println("Os vencedores da Partida Duplas são: " + dupla1[0].getNome() + " e " + dupla1[1].getNome());
            for (Jogador jogador : dupla1) {
                jogador.setRankings(jogador.getRankings() + 5);
            }
            return dupla1;
        } else {
            System.out.println("Os vencedores da Partida Duplas são: " + dupla2[0].getNome() + " e " + dupla2[1].getNome());
            for (Jogador jogador : dupla2) {
                jogador.setRankings(jogador.getRankings() + 5);
            }
            return dupla2;
        }
    }

    @Override
    public double tempoPartida() {
        return 40.0;
    }
}