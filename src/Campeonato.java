package src;

public class Campeonato {
    private TorneioDuplas torneioDuplas;
    private TorneioSingulares torneioSingulares;

    public Campeonato() {
        this.torneioDuplas = new TorneioDuplas();
        this.torneioSingulares = new TorneioSingularesEleminatorio(); // Exemplo de implementação concreta
    }

    public void medalharVencedorTorneios() {
        Jogador vencedorSingulares = torneioSingulares.determinarVencedorTorneioSingulares();
        Jogador[] vencedoresDuplas = torneioDuplas.getVencedores();

        if (vencedorSingulares != null) {
            System.out.println("Medalha de ouro para o vencedor do torneio de singulares: " + vencedorSingulares.getNome());
        }

        if (vencedoresDuplas != null && vencedoresDuplas.length == 2) {
            System.out.println("Medalha de ouro para os vencedores do torneio de duplas: " + vencedoresDuplas[0].getNome() + " e " + vencedoresDuplas[1].getNome());
        }
    }

    // Métodos adicionais para adicionar jogadores, árbitros, etc.
}