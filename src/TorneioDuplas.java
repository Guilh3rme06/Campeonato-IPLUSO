package src;

import java.util.ArrayList;

public class TorneioDuplas {
    private ArrayList<PartidaDuplas> partidas;

    public TorneioDuplas() {
        this.partidas = new ArrayList<>();
    }

    public void adicionarPartida(PartidaDuplas partida) {
        partidas.add(partida);
    }

    public Jogador[] determinarVencedorTorneioDuplas() {
        if (partidas.isEmpty()) {
            return null;
        }

        // Exemplo de lógica simples: os vencedores da última partida são os vencedores do torneio
        PartidaDuplas ultimaPartida = partidas.get(partidas.size() - 1);
        return ultimaPartida.determinarVencedores();
    }

    public Jogador[] getVencedores() {
        return determinarVencedorTorneioDuplas();
    }
}