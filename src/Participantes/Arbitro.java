package Participantes;

import java.util.ArrayList;

/**
 * Classe que representa um arbitro.
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
     * Define as certificações do arbitro.
     * @param certificacoes Certificacoes do arbitro.
     */
    public void setCertificacoes(String certificacoes) {
        this.certificacoes = certificacoes;
    }

    /**
     * Adiciona um arbitro a lista de arbitros.
     * @param arbitro arbitro a ser adicionado.
     */
    public static void adicionarArbitro(Arbitro arbitro) {
        arbitros.add(arbitro);
    }

    /**
     * Obtem a lista de arbitros.
     * @return Lista de arbitros.
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