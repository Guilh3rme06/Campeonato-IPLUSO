import java.util.Scanner;

public class Jogador extends Pessoa {
    private int rankings;
    private int partidasJogadas;

    // Construtor
    public Jogador(String nome, int idade, char genero, int rankings, int partidasJogadas) {
        super(nome, idade, genero);
        this.rankings = rankings;
        this.partidasJogadas = partidasJogadas;
    }
    
    // Getter
    public int getRankings() {
        return rankings;
    }

    public int getPartidasJogadas() {
        return partidasJogadas;
    }

    // Setter
    public void setRankings(int rankings) {
        this.rankings = rankings;
    }

    public void setPartidasJogadas(int partidasJogadas) {
        this.partidasJogadas = partidasJogadas;
    }

    @Override
    public void registro(Scanner scanner) {
        System.out.println("Nome: ");
        setNome(scanner.nextLine());

        System.out.println("Idade: ");
        setIdade(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Género: ");
        setGenero(scanner.next().charAt(0));
        scanner.nextLine();

        this.rankings = 0;
        this.partidasJogadas = 0;
    }

    public void exibirJogador() {
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Género: " + getGenero());
        System.out.println("Rankings: " + getRankings());
        System.out.println("Partidas Jogadas: " + getPartidasJogadas());
    }

}