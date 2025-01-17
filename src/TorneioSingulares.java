package src;

import java.util.ArrayList;

/**
 * Classe abstrata que representa um torneio de singulares.
 */
public abstract class TorneioSingulares {
    protected ArrayList<PartidaSingulares> partidas;

    /**
     * Construtor para inicializar um torneio de singulares.
     */
    public TorneioSingulares() {
        this.partidas = new ArrayList<>();
    }

    /**
     * Adiciona uma partida ao torneio.
     * @param partida Partida a ser adicionada.
     */
    public void adicionarPartida(PartidaSingulares partida) {
        partidas.add(partida);
    }

    /**
     * Obtém a lista de partidas do torneio.
     * @return Lista de partidas.
     */
    public ArrayList<PartidaSingulares> getPartidas() {
        return partidas;
    }

    /**
     * Determina o vencedor do torneio de singulares.
     * @return Vencedor do torneio.
     */
    public abstract Jogador determinarVencedorTorneioSingulares();
}