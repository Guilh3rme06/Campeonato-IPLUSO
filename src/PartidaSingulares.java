import java.util.Random;

public class PartidaSingulares{
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

    // Setters
    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public void partidaSingular(){
        this.jogador1.setPartidasJogadas(jogador1.getPartidasJogadas() + 1);
        this.jogador2.setPartidasJogadas(jogador2.getPartidasJogadas() + 1);

        Random vencedorPartidaSingular = new Random();
        int vencedor = vencedorPartidaSingular.nextInt(2) + 1;

        if(vencedor == 1) {
            System.out.println("O vencedor da Partida Singular é: " + this.jogador1.getNome());
            this.jogador1.setRankings(jogador1.getRankings() + 3);
        } else {
            System.out.println("O vencedor da Partida Singular é: " + this.jogador2.getNome());
            this.jogador2.setRankings(jogador2.getRankings() + 3);
        }
    }
}