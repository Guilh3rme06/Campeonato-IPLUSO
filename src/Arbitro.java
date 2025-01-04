import java.util.Scanner;

public class Arbitro extends Pessoa {
    private String certificacoes;

    // Construtor
    public Arbitro(String nome, int idade, char genero, String certificacoes) {
        super(nome, idade, genero);
        this.certificacoes = certificacoes;
    }
    
    // Getter
    public String getCertificacoes() {
        return certificacoes;
    }

    // Setter
    public void setCertificacoes(String certificacoes) {
        this.certificacoes = certificacoes;
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

        System.out.println("Certificações: ");
        setCertificacoes(scanner.nextLine());
    }

    public void exibirArbitro() {
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Género: " + getGenero());
        System.out.println("Certificações: " + getCertificacoes());
    }
}