package src;

import java.util.ArrayList;

public abstract class TorneioDuplas {
    protected ArrayList<PartidaDuplas> partidas;

    public TorneioDuplas() {
        this.partidas = new ArrayList<>();
    }

    public void adicionarPartida(PartidaDuplas partida) {
        partidas.add(partida);
    }

    public ArrayList<PartidaDuplas> getPartidas() {
        return partidas;
    }

    public abstract Jogador[] determinarVencedorTorneioDuplas();
}