import java.util.Random;
import java.util.Scanner;

public class PartidaDuplas {
    private Jogador jogador1Eq1;
    private Jogador jogador2Eq1;
    private Jogador jogador1Eq2;
    private Jogador jogador2Eq2;
    private Arbitro arbitro;
    private String resultado;

    public PartidaDuplas(Jogador jogador1Eq1, Jogador jogador2Eq1, Jogador jogador1Eq2, Jogador jogador2Eq2,
            Arbitro arbitro) {
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
        Scanner jogadores = new Scanner(System.in);
        System.out.println("Defina o género da partida:");
        String genero = jogadores.nextLine();
        if (genero.equals("M") || genero.equals("m")) {
            System.out.println("Jogo Masculino");
            System.out.println("Insira o Jogador 1:");
            String nome1 = jogadores.nextLine();
            jogador1Eq1.setNome(nome1);
            if (jogador1Eq1.getGenero() == 'F' || jogador1Eq1.getGenero() == 'f') {
                System.out.println("Jogador não permitido!");
                nome1 = null;
                System.out.println("Insira o Jogador 1:");
                nome1 = jogadores.nextLine();
                jogador1Eq1.setNome(nome1);
            }
            System.out.println("Insira o Jogador 2:");
            String nome2 = jogadores.nextLine();
            jogador2Eq1.setNome(nome2);
            if (jogador2Eq1.getGenero() == 'F' || jogador2Eq1.getGenero() == 'f') {
                System.out.println("Jogador não permitido!");
                nome2 = null;
                System.out.println("Insira o jogador 2:");
                nome2 = jogadores.nextLine();
                jogador2Eq1.setNome(nome2);
            }
            System.out.println("Insira o Jogador 3:");
            String nome3 = jogadores.nextLine();
            jogador1Eq2.setNome(nome3);
            if (jogador1Eq2.getGenero() == 'F' || jogador1Eq2.getGenero() == 'f') {
                System.out.println("Jogador não permitido!");
                nome3 = null;
                System.out.println("Insira o jogador 3:");
                nome3 = jogadores.nextLine();
                jogador1Eq2.setNome(nome3);
            }
            System.out.println("Insira o Jogador 4:");
            String nome4 = jogadores.nextLine();
            jogador2Eq2.setNome(nome4);
            if (jogador2Eq2.getGenero() == 'F' || jogador2Eq2.getGenero() == 'f') {
                System.out.println("Jogador não permitido!");
                nome4 = null;
                System.out.println("Insira o jogador 4:");
                nome4 = jogadores.nextLine();
                jogador2Eq2.setNome(nome4);
            }
        } else {
            System.out.println("Jogo Feminino");
            System.out.println("Insira o Jogador 1:");
            String nome1 = jogadores.nextLine();
            jogador1Eq1.setNome(nome1);
            if (jogador1Eq1.getGenero() == 'M' || jogador1Eq1.getGenero() == 'm') {
                System.out.println("Jogador nÃo permitido!");
                nome1 = null;
                System.out.println("Insira o Jogador 1:");
                nome1 = jogadores.nextLine();
                jogador1Eq1.setNome(nome1);
            }
            System.out.println("Insira o Jogador 2:");
            String nome2 = jogadores.nextLine();
            jogador2Eq1.setNome(nome2);
            if (jogador2Eq1.getGenero() == 'M' || jogador2Eq1.getGenero() == 'm') {
                System.out.println("Jogador não permitido!");
                nome2 = null;
                System.out.println("Insira o Jogador 2:");
                nome2 = jogadores.nextLine();
                jogador2Eq1.setNome(nome2);
            }
            System.out.println("Insira o Jogador 3:");
            String nome3 = jogadores.nextLine();
            jogador1Eq2.setNome(nome3);
            if (jogador1Eq2.getGenero() == 'M' || jogador1Eq2.getGenero() == 'm') {
                System.out.println("Jogador não permitido!");
                nome3 = null;
                System.out.println("Insira o Jogador 3:");
                nome3 = jogadores.nextLine();
                jogador1Eq2.setNome(nome3);
            }
            System.out.println("Insira o Jogador 4:");
            String nome4 = jogadores.nextLine();
            jogador2Eq2.setNome(nome4);
            if (jogador2Eq2.getGenero() == 'M' || jogador2Eq2.getGenero() == 'm') {
                System.out.println("Jogador não permitido!");
                nome4 = null;
                System.out.println("Insira o Jogador 4:");
                nome4 = jogadores.nextLine();
                jogador2Eq2.setNome(nome4);
            }
        }
        jogadores.close();
        this.jogador1Eq1.setPartidasJogadas(jogador1Eq1.getPartidasJogadas() + 1);
        this.jogador2Eq1.setPartidasJogadas(jogador2Eq1.getPartidasJogadas() + 1);
        this.jogador1Eq2.setPartidasJogadas(jogador1Eq2.getPartidasJogadas() + 1);
        this.jogador2Eq2.setPartidasJogadas(jogador2Eq2.getPartidasJogadas() + 1);

        Random vencedorPartidaDuplas = new Random();
        int vencedor = vencedorPartidaDuplas.nextInt(2) + 1;

        if (vencedor == 1) {
            resultado = "Os Vencedores da Partida Duplas são: " + jogador1Eq1.getNome() + " e " + jogador2Eq1.getNome();
            this.jogador1Eq1.setRankings(jogador1Eq1.getRankings() + 3);
            this.jogador2Eq1.setRankings(jogador2Eq1.getRankings() + 3);
            return new Jogador[] { jogador1Eq1, jogador2Eq1 };
        } else {
            resultado = "Os Vencedores da Partida Duplas são: " + jogador1Eq2.getNome() + " e " + jogador2Eq2.getNome();
            this.jogador1Eq2.setRankings(jogador1Eq2.getRankings() + 3);
            this.jogador2Eq2.setRankings(jogador2Eq2.getRankings() + 3);
            return new Jogador[] { jogador1Eq2, jogador2Eq2 };
        }
    }

    /**
     * Obtém o tempo da partida de duplas.
     * 
     * @return Tempo da partida de duplas.
     */
    public double tempoPartida() {
        return 40.0;
    }
}