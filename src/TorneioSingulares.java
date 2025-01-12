package src;

import java.util.ArrayList;

public abstract class TorneioSingulares {
    protected ArrayList<PartidaSingulares> partidas;

    public TorneioSingulares() {
        this.partidas = new ArrayList<>();
    }

    public void adicionarPartida(PartidaSingulares partida) {
        partidas.add(partida);
    }

    public abstract Jogador determinarVencedorTorneioSingulares();
}