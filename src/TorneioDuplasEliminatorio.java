import java.util.ArrayList;

public class TorneioDuplasEliminatorio extends TorneioDuplas {
    private ArrayList<Arbitro> arbitros;

    public TorneioDuplasEliminatorio(ArrayList<Arbitro> arbitros) {
        super();
        this.arbitros = arbitros;
    }

    @Override
    public Jogador[] determinarVencedorTorneioDuplas() {
        if (partidas.isEmpty()) {
            return null;
        }

        ArrayList<Jogador[]> vencedores = new ArrayList<>();
        for (PartidaDuplas partida : partidas) {
            vencedores.add(partida.determinarVencedores());
        }

        while (vencedores.size() > 1) {
            ArrayList<Jogador[]> proximosVencedores = new ArrayList<>();
            for (int i = 0; i < vencedores.size(); i += 2) {
                if (i + 1 < vencedores.size()) {
                    Jogador[] dupla1 = vencedores.get(i);
                    Jogador[] dupla2 = vencedores.get(i + 1);
                    Arbitro arbitro = arbitros.get((int) (Math.random() * arbitros.size()));
                    PartidaDuplas partida = new PartidaDuplas(dupla1, dupla2, arbitro);
                    adicionarPartida(partida);
                    proximosVencedores.add(partida.determinarVencedores());
                } else {
                    proximosVencedores.add(vencedores.get(i));
                }
            }
            vencedores = proximosVencedores;
        }

        return vencedores.get(0);
    }

    public void iniciarTorneio(ArrayList<Jogador[]> duplas) {
        ArrayList<Jogador[]> participantes = new ArrayList<>(duplas);

        while (participantes.size() > 1) {
            ArrayList<Jogador[]> proximosVencedores = new ArrayList<>();
            for (int i = 0; i < participantes.size(); i += 2) {
                if (i + 1 < participantes.size()) {
                    Jogador[] dupla1 = participantes.get(i);
                    Jogador[] dupla2 = participantes.get(i + 1);
                    Arbitro arbitro = arbitros.get((int) (Math.random() * arbitros.size()));
                    PartidaDuplas partida = new PartidaDuplas(dupla1, dupla2, arbitro);
                    adicionarPartida(partida);
                    proximosVencedores.add(partida.determinarVencedores());
                } else {
                    proximosVencedores.add(participantes.get(i));
                }
            }
            participantes = proximosVencedores;
        }
    }
}