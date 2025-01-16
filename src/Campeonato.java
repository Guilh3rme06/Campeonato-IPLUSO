package src;

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

    public void medalharVencedorTorneios() {
        Jogador vencedorSingulares = torneioSingulares.determinarVencedorTorneioSingulares();
        Jogador[] vencedoresDuplas = torneioDuplas.determinarVencedorTorneioDuplas();

        if (vencedorSingulares != null) {
            System.out.println("Medalha de ouro para o vencedor do torneio de singulares: " + vencedorSingulares.getNome());
        }

        if (vencedoresDuplas != null && vencedoresDuplas.length == 2) {
            System.out.println("Medalha de ouro para os vencedores do torneio de duplas: " + vencedoresDuplas[0].getNome() + " e " + vencedoresDuplas[1].getNome());
        }
    }
}