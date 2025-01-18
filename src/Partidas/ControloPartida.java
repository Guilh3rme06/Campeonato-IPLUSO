package Partidas;

import Participantes.*;
/**
 * Interface que define o controle de uma partida.
 */
public interface ControloPartida {
    /**
     * Aplica as regras da partida.
     * @return Regras aplicadas.
     */
    String aplicarRegras();

    /**
     * Determina o vencedor da partida.
     * @return Vencedor da partida.
     */
    Jogador determinarVencedor();

    /**
     * Obtém o tempo da partida.
     * @return Tempo da partida.
     */
    double tempoPartida();
}