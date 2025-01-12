import java.util.ArrayList;

public class TorneioSingularesEleminatorio extends TorneioSingulares {
    public TorneioSingularesEleminatorio() {
        super();
    }

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
                    proximosVencedores.add(novaPartida.determinarVencedor());
                } else {
                    proximosVencedores.add(vencedores.get(i));
                }
            }
            vencedores = proximosVencedores;
        }

        return vencedores.get(0);
    }
}