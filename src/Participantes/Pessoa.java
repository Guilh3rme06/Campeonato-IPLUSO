package Participantes;

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
     * @param genero Genero da pessoa.
     */
    public Pessoa(String nome, int idade, char genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }

    /**
     * Obtem o nome da pessoa.
     * @return Nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da pessoa.
     * @param nome Nome da pessoa.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtem a idade da pessoa.
     * @return Idade da pessoa.
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Define a idade da pessoa.
     * @param idade Idade da pessoa.
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Obtem o genero da pessoa.
     * @return Genero da pessoa.
     */
    public char getGenero() {
        return genero;
    }

    /**
     * Define o genero da pessoa.
     * @param genero Genero da pessoa.
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }
}