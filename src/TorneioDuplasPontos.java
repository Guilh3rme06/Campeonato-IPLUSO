package src;

import java.util.ArrayList;

/**
 * Classe que representa um torneio de duplas no formato de pontos.
 */
public class TorneioDuplasPontos extends TorneioDuplas {

    /**
     * Construtor para inicializar um torneio de duplas no formato de pontos.
     */
    public TorneioDuplasPontos() {
        super();
    }

    /**
     * Determina os vencedores do torneio de duplas no formato de pontos.
     *
     * @return Array de jogadores vencedores do torneio de duplas.
     */
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
            Jogador[] vencedores = partida.determinarVencedores();
            int index = duplas.indexOf(vencedores);
            if (index == -1) {
                duplas.add(vencedores);
                pontos.add(1);
            } else {
                pontos.set(index, pontos.get(index) + 1);
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

    /**
     * Inicia o torneio de duplas com as duplas fornecidas.
     *
     * @param duplas Lista de duplas participantes do torneio.
     */
    public void iniciarTorneio(ArrayList<Jogador[]> duplas) {
        ArrayList<Jogador[]> participantes = new ArrayList<>(duplas);

        // Garantir que cada dupla jogue 6 jogos
        for (int i = 0; i < participantes.size(); i++) {
            for (int j = 0; j < participantes.size(); j++) {
                if (i != j) {
                    for (int k = 0; k < 1; k++) {
                        Jogador[] dupla1 = participantes.get(i);
                        Jogador[] dupla2 = participantes.get(j);
                        Arbitro arbitro = Arbitro.getArbitros().get((int) (Math.random() * Arbitro.getArbitros().size()));
                        PartidaDuplas partida = new PartidaDuplas(dupla1, dupla2, arbitro);
                        adicionarPartida(partida);
                        partida.determinarVencedores();
                    }
                }
            }
        }
    }
}