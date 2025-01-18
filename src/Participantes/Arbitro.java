package Participantes;

import java.util.ArrayList;

/**
 * Classe que representa um árbitro.
 */
public class Arbitro extends Pessoa {
    private String certificacoes;
    private static ArrayList<Arbitro> arbitros = new ArrayList<>();

    // Construtor
    public Arbitro(String nome, int idade, char genero, String certificacoes) {
        super(nome, idade, genero);
        this.certificacoes = certificacoes;
    }

    /**
     * Define as certificações do árbitro.
     * @param certificacoes Certificações do árbitro.
     */
    public void setCertificacoes(String certificacoes) {
        this.certificacoes = certificacoes;
    }

    /**
     * Adiciona um árbitro à lista de árbitros.
     * @param arbitro Árbitro a ser adicionado.
     */
    public static void adicionarArbitro(Arbitro arbitro) {
        arbitros.add(arbitro);
    }

    /**
     * Obtém a lista de árbitros.
     * @return Lista de árbitros.
     */
    public static ArrayList<Arbitro> getArbitros() {
        return arbitros;
    }

    @Override
    public String toString() {
        return "Arbitro{" +
                "nome='" + getNome() + '\'' +
                ", idade=" + getIdade() +
                ", genero=" + getGenero() +
                ", certificacoes='" + certificacoes + '\'' +
                '}';
    }
}