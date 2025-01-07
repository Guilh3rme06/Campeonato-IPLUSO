package src;

/**
 * Classe abstrata que representa uma pessoa no campeonato.
 */
public abstract class Pessoa {
    private String nome;
    private int idade;
    private char genero;

    /**
     * Construtor da classe Pessoa.
     * @param nome Nome da pessoa.
     * @param idade Idade da pessoa.
     * @param genero Gênero da pessoa.
     */
    public Pessoa(String nome, int idade, char genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
}
