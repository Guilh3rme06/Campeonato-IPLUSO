import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Jogador> jogadores = new ArrayList<>();
        ArrayList<Arbitro> arbitros = new ArrayList<>();

        // Menu
        while (true) {
            System.out.println("Menu");
            System.out.println("1 - Registro do Jogador");
            System.out.println("2 - Registro do Arbitro");
            System.out.println("3 - Gerar/Controlar Torneio");
            System.out.println("4 - Visualizar Campeonato");
            System.out.println("5 - Listar Jogadores e Árbitros");
            System.out.println("6 - Criar e Exibir Partida Singular");
            System.out.println("7 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha restante

            switch (opcao) {
                case 1:
                    // Jogador
                    Jogador jogador = new Jogador("", 0, ' ', 0, 0);
                    System.out.println("\nRegistro do Jogador");
                    jogador.registro(scanner);
                    jogador.exibirJogador();
                    jogadores.add(jogador);
                    break;
                case 2:
                    // Arbitro
                    Arbitro arbitro = new Arbitro("", 0, ' ', "");
                    System.out.println("Registro do Arbitro");
                    arbitro.registro(scanner);
                    arbitro.exibirArbitro();
                    arbitros.add(arbitro);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    // Mostrar Jogadores e Árbitros
                    System.out.println("Jogadores Registrados:");
                    for (Jogador j : jogadores) {
                        j.exibirJogador();
                        System.out.println();
                    }
                    System.out.println("Árbitros Registrados:");
                    for (Arbitro a : arbitros) {
                        a.exibirArbitro();
                        System.out.println();
                    }
                    break;
                case 6:
                    // Partida Singular
                    if (jogadores.size() < 2 || arbitros.isEmpty()) {
                        System.out.println("Não há jogadores ou árbitros suficientes para criar uma partida.");
                    } else {
                        Jogador jogador1 = jogadores.get(0);
                        Jogador jogador2 = jogadores.get(1);
                        Arbitro arbitroPartida = arbitros.get(0);

                        PartidaSingulares partida = new PartidaSingulares(jogador1, jogador2, arbitroPartida);
                        partida.partidaSingular();
                    }
                    break;
                case 7:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}