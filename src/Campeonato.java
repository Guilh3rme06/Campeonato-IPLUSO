import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Campeonato {
    private TorneioDuplas torneioDuplas;
    private TorneioSingulares torneioSingulares;

    public Campeonato() {
        this.torneioDuplas = new TorneioDuplasEliminatorio(new ArrayList<>());
        this.torneioSingulares = new TorneioSingularesEleminatorio();
    }

    public void adicionarTorneioSingulares(TorneioSingulares torneio) {
        this.torneioSingulares = torneio;
    }

    public void adicionarTorneioDuplas(TorneioDuplas torneio) {
        this.torneioDuplas = torneio;
    }

    public TorneioSingulares getTorneioSingulares() {
        return torneioSingulares;
    }

    public TorneioDuplas getTorneioDuplas() {
        return torneioDuplas;
    }

    public void medalharVencedorTorneios() {
        Jogador vencedorSingulares = torneioSingulares.determinarVencedorTorneioSingulares();
        Jogador[] vencedoresDuplas = torneioDuplas.determinarVencedorTorneioDuplas();

        if (vencedorSingulares != null) {
            Premio premioSingulares = new Premio("Singulares", 30000);
            System.out.println("Medalha de ouro para o vencedor do torneio de singulares: " + vencedorSingulares.getNome()
                + " - Prémio: " + premioSingulares.getValor());
        }

        if (vencedoresDuplas != null && vencedoresDuplas.length == 2) {
            Premio premioDuplas = new Premio("Duplas", 40000);
            System.out.println("Medalha de ouro para os vencedores do torneio de duplas: "
                + vencedoresDuplas[0].getNome() + " e " + vencedoresDuplas[1].getNome()
                + " - Prémio: " + premioDuplas.getValor());
        }
    }

    public static void exportarRankingsParaFicheiro(String nomeFicheiro) {
        ArrayList<Jogador> jogadores = Jogador.getJogadores();

        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeFicheiro))) {
            writer.println("Rankings dos Jogadores:");
            for (Jogador jogador : jogadores) {
                writer.println(jogador.getNome() + " - Ranking: " + jogador.getRankings() + " - Partidas Jogadas: "
                        + jogador.getPartidasJogadas());
            }
            System.out.println("Rankings exportados com sucesso para " + nomeFicheiro);
        } catch (IOException e) {
            System.err.println("Erro ao exportar rankings: " + e.getMessage());
        }
    }
}