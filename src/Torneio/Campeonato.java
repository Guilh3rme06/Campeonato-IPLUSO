import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Participantes.*;

/**
 * Classe que representa um campeonato.
 */
public class Campeonato {
    private TorneioDuplas torneioDuplas;
    private TorneioSingulares torneioSingulares;

    /**
     * Construtor para inicializar um campeonato.
     */
    public Campeonato() {
        this.torneioDuplas = new TorneioDuplasEliminatorio(new ArrayList<>());
        this.torneioSingulares = new TorneioSingularesEleminatorio();
    }

    /**
     * Adiciona um torneio de singulares ao campeonato.
     * @param torneio Torneio de singulares a ser adicionado.
     */
    public void adicionarTorneioSingulares(TorneioSingulares torneio) {
        this.torneioSingulares = torneio;
    }

    /**
     * Adiciona um torneio de duplas ao campeonato.
     * @param torneio Torneio de duplas a ser adicionado.
     */
    public void adicionarTorneioDuplas(TorneioDuplas torneio) {
        this.torneioDuplas = torneio;
    }

    /**
     * Obtém o torneio de singulares do campeonato.
     * @return Torneio de singulares.
     */
    public TorneioSingulares getTorneioSingulares() {
        return torneioSingulares;
    }

    /**
     * Obtém o torneio de duplas do campeonato.
     * @return Torneio de duplas.
     */
    public TorneioDuplas getTorneioDuplas() {
        return torneioDuplas;
    }
    
    /**
     * Medalha os vencedores dos torneios de singulares e duplas.
     */
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

    /**
     * Exporta os rankings dos jogadores para um ficheiro.
     * @param nomeFicheiro Nome do ficheiro para exportar os rankings.
     */
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