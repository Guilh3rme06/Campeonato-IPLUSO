import java.util.Random;
import java.util.Scanner;
public class PartidaSingulares implements ControloPartida{
    private Jogador jogador1;
    private Jogador jogador2;
    private Arbitro arbitro;

    // Construtor
    public PartidaSingulares(Jogador jogador1, Jogador jogador2, Arbitro arbitro) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.arbitro = arbitro;
    }

    // Getters
    public Jogador getJogador1() {
        return jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    // Regras
    @Override
    public String aplicarRegras(){
        return "Regras";
    }
    @Override
    public Jogador determinarVencedor(){
        Scanner jogadores = new Scanner(System.in);
        System.out.println("Defina o genero da partida:");
        String genero = jogadores.nextLine();
        if (genero.equals("M")) {
            System.out.println("Jogo masculino");
            System.out.println("Insira o jogador1:");
            String nome1 = jogadores.nextLine();
            jogador1.setNome(nome1);
            System.out.println("Insira o jogador2:");
            String nome2 = jogadores.nextLine();
            jogador2.setNome(nome2);
        }else{
            System.out.println("Jogo Feminino");
            System.out.println("Insira o jogador1:");
            String nome1 = jogadores.nextLine();
            jogador1.setNome(nome1);
            System.out.println("Insira o jogador2:");
            String nome2 = jogadores.nextLine();
            jogador2.setNome(nome2);

        }
        this.jogador1.setPartidasJogadas(jogador1.getPartidasJogadas() + 1);
        this.jogador2.setPartidasJogadas(jogador2.getPartidasJogadas() + 1);

        Random vencedorPartidaSingular = new Random();
        int vencedor = vencedorPartidaSingular.nextInt(2) + 1;

        if(vencedor == 1) {
            System.out.println("O vencedor da Partida Singular é: " + this.jogador1.getNome());
            this.jogador1.setRankings(jogador1.getRankings() + 3);
            return this.jogador1;
        } else {
            System.out.println("O vencedor da Partida Singular é: " + this.jogador2.getNome());
            this.jogador2.setRankings(jogador2.getRankings() + 3);
            return this.jogador2;
        }
    }
    @Override
    public double tempoPartida(){
        return 30.0;
    }
}