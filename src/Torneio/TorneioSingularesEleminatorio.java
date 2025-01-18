import java.util.ArrayList;
import Participantes.Arbitro;
import Participantes.Jogador;
import Partidas.PartidaSingulares;

/**
 * Classe que representa um torneio de singulares por eliminação.
 */
public class TorneioSingularesEleminatorio extends TorneioSingulares {
    /**
     * Construtor para inicializar um torneio de singulares por eliminação.
     */
    public TorneioSingularesEleminatorio() {
        super();
    }

    /**
     * Determina o vencedor do torneio de singulares por eliminação.
     * @return Vencedor do torneio.
     */
    @Override
    public Jogador determinarVencedorTorneioSingulares() {
        if (partidas.isEmpty()) {
            return null;
        }

        ArrayList<Jogador> vencedores = new ArrayList<>();
        for (PartidaSingulares partida : partidas) {
            vencedores.add(partida.determinarVencedor());
        }

        while (vencedores.size() > 1) {
            ArrayList<Jogador> proximosVencedores = new ArrayList<>();
            for (int i = 0; i < vencedores.size(); i += 2) {
                if (i + 1 < vencedores.size()) {
                    Jogador jogador1 = vencedores.get(i);
                    Jogador jogador2 = vencedores.get(i + 1);
                    PartidaSingulares novaPartida = new PartidaSingulares(jogador1, jogador2, new Arbitro("Árbitro", 40, 'M', "Certificação A"));
                    adicionarPartida(novaPartida);
                    proximosVencedores.add(novaPartida.determinarVencedor());
                } else {
                    proximosVencedores.add(vencedores.get(i));
                }
            }
            vencedores = proximosVencedores;
        }

        return vencedores.get(0);
    }

    /**
     * Inicia o torneio de singulares com uma lista de jogadores.
     * @param jogadores Lista de jogadores participantes.
     */
    public void iniciarTorneio(ArrayList<Jogador> jogadores) {
        ArrayList<Jogador> participantes = new ArrayList<>(jogadores);

        while (participantes.size() > 1) {
            ArrayList<Jogador> proximosParticipantes = new ArrayList<>();
            for (int i = 0; i < participantes.size(); i += 2) {
                if (i + 1 < participantes.size()) {
                    Jogador jogador1 = participantes.get(i);
                    Jogador jogador2 = participantes.get(i + 1);
                    PartidaSingulares partida = new PartidaSingulares(jogador1, jogador2, new Arbitro("Árbitro", 40, 'M', "Certificação A"));
                    adicionarPartida(partida);
                    Jogador vencedor = partida.determinarVencedor();
                    proximosParticipantes.add(vencedor);
                } else {
                    proximosParticipantes.add(participantes.get(i));
                }
            }
            participantes = proximosParticipantes;
        }
    }
}