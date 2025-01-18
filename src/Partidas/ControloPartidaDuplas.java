package Partidas;

import Participantes.*;
/**
 * Interface que define o controle de uma partida de duplas.
 */
public interface ControloPartidaDuplas {
    /**
     * Aplica as regras da partida de duplas.
     * @return Regras aplicadas.
     */
    String aplicarRegras();

    /**
     * Determina os vencedores da partida de duplas.
     * @return Array de jogadores vencedores.
     */
    Jogador[] determinarVencedores();

    /**
     * Obtém o tempo da partida de duplas.
     * @return Tempo da partida.
     */
    double tempoPartida();
}