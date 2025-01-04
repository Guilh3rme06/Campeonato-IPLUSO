import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Arbitro
        // Arbitro arbitro = new Arbitro("", 0, ' ', "");
        // System.out.println("Registro do Arbitro:");
        // arbitro.registro(scanner);
        // arbitro.exibirArbitro();

        // Jogador
        // Jogador jogador = new Jogador("", 0, ' ', 0, 0);
        // System.out.println("\nRegistro do Jogador:");
        // jogador.registro(scanner);
        // jogador.exibirJogador();

        // scanner.close();

        // Menu
        while(true) {
            System.out.println("Menu");
            System.out.println("1 - Registro do Jogador");
            System.out.println("2 - Registro do Arbitro");
            System.out.println("3 - Gerar/Controlar Torneio");
            System.out.println("4 - Visualizar Campeonato");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcao) {
                case 1:
                    // Jogador
                    Jogador jogador = new Jogador("", 0, ' ', 0, 0);
                    System.out.println("\nRegistro do Jogador");
                    jogador.registro(scanner);
                    jogador.exibirJogador();
                    break;
                case 2:
                    // Arbitro
                    Arbitro arbitro = new Arbitro("", 0, ' ', "");
                    System.out.println("Registro do Arbitro");
                    arbitro.registro(scanner);
                    arbitro.exibirArbitro();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
