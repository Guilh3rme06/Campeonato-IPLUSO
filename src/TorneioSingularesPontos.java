package src;

import java.util.ArrayList;

/**
 * Classe que representa um torneio de singulares por pontos.
 */
public class TorneioSingularesPontos extends TorneioSingulares {
    /**
     * Construtor para inicializar um torneio de singulares por pontos.
     */
    public TorneioSingularesPontos() {
        super();
    }

    /**
     * Determina o vencedor do torneio de singulares por pontos.
     * @return Vencedor do torneio.
     */
    @Override
    public Jogador determinarVencedorTorneioSingulares() {
        if (partidas.isEmpty()) {
            return null;
        }

        // Lista para armazenar os jogadores e seus pontos
        ArrayList<Jogador> jogadores = new ArrayList<>();
        ArrayList<Integer> pontos = new ArrayList<>();

        // Calcular os pontos dos jogadores
        for (PartidaSingulares partida : partidas) {
            Jogador vencedor = partida.determinarVencedor();
            if (vencedor != null) {
                int index = jogadores.indexOf(vencedor);
                if (index == -1) {
                    jogadores.add(vencedor);
                    pontos.add(1);
                } else {
                    pontos.set(index, pontos.get(index) + 1);
                }
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