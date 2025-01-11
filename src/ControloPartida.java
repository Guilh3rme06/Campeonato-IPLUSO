package src;

public interface ControloPartida {
    String aplicarRegras();
    Jogador determinarVencedor();
    double tempoPartida();
    
}
