package src;

import java.util.ArrayList;
import java.util.List;

public class TorneioSingluaresPontos extends TorneioSingulares {
    public TorneioSingluaresPontos() {
        super();
    }

    @Override
    public Jogador determinarVencedorTorneioSingulares() {
        if (partidas.isEmpty()) {
            return null;
        }

        // Lista para armazenar os jogadores e seus pontos
        List<Jogador> jogadores = new ArrayList<>();
        List<Integer> pontos = new ArrayList<>();

        // Calcular os pontos dos jogadores
        for (PartidaSingulares partida : partidas) {
            Jogador vencedorPartida = partida.determinarVencedor();
            int index = jogadores.indexOf(vencedorPartida);
            if (index == -1) {
                jogadores.add(vencedorPartida);
                pontos.add(3);
            } else {
                pontos.set(index, pontos.get(index) + 3);
            }
        }

        // Determinar o jogador com mais pontos
        Jogador vencedor = null;
        int maxPontos = 0;
        for (int i = 0; i < jogadores.size(); i++) {
            if (pontos.get(i) > maxPontos) {
                maxPontos = pontos.get(i);
                vencedor = jogadores.get(i);
            }
        }

        return vencedor;
    }
}