

import java.util.ArrayList;

import Participantes.Jogador;
import Partidas.PartidaDuplas;

/**
 * Classe abstrata que representa um torneio de duplas.
 */
public abstract class TorneioDuplas {
    protected ArrayList<PartidaDuplas> partidas;

    /**
     * Construtor para inicializar um torneio de duplas.
     */
    public TorneioDuplas() {
        this.partidas = new ArrayList<>();
    }

    /**
     * Adiciona uma partida ao torneio de duplas.
     *
     * @param partida Partida de duplas a ser adicionada.
     */
    public void adicionarPartida(PartidaDuplas partida) {
        partidas.add(partida);
    }

    /**
     * Obtém a lista de partidas do torneio de duplas.
     *
     * @return Lista de partidas do torneio de duplas.
     */
    public ArrayList<PartidaDuplas> getPartidas() {
        return partidas;
    }

    /**
     * Determina os vencedores do torneio de duplas.
     *
     * @return Array de jogadores vencedores do torneio de duplas.
     */
    public abstract Jogador[] determinarVencedorTorneioDuplas();
}