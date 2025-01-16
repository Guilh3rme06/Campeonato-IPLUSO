package src;

import java.util.ArrayList;

public class TorneioDuplasPontos extends TorneioDuplas {
    public TorneioDuplasPontos() {
        super();
    }

    @Override
    public Jogador[] determinarVencedorTorneioDuplas() {
        if (partidas.isEmpty()) {
            return null;
        }

        // Lista para armazenar as duplas e seus pontos
        ArrayList<Jogador[]> duplas = new ArrayList<>();
        ArrayList<Integer> pontos = new ArrayList<>();

        // Calcular os pontos das duplas
        for (PartidaDuplas partida : partidas) {
            Jogador[] vencedoresPartida = partida.determinarVencedores();
            int index = -1;
            for (int i = 0; i < duplas.size(); i++) {
                if (duplas.get(i)[0].equals(vencedoresPartida[0]) && duplas.get(i)[1].equals(vencedoresPartida[1])) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                duplas.add(vencedoresPartida);
                pontos.add(3);
            } else {
                pontos.set(index, pontos.get(index) + 3);
            }
        }

        // Determinar a dupla com mais pontos
        Jogador[] vencedores = null;
        int maxPontos = 0;
        for (int i = 0; i < duplas.size(); i++) {
            if (pontos.get(i) > maxPontos) {
                maxPontos = pontos.get(i);
                vencedores = duplas.get(i);
            }
        }

        return vencedores;
    }
}