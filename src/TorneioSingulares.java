import java.util.ArrayList;

public abstract class TorneioSingulares {
    protected ArrayList<PartidaSingulares> partidas;

    public TorneioSingulares() {
        this.partidas = new ArrayList<>();
    }

    public void adicionarPartida(PartidaSingulares partida) {
        partidas.add(partida);
    }

    public ArrayList<PartidaSingulares> getPartidas() {
        return partidas;
    }
    public abstract Jogador determinarVencedorTorneioSingulares();
}