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

    /**
     * Obtém o nome da pessoa.
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
     * Obtém a idade da pessoa.
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
     * Obtém o gênero da pessoa.
     * @return Gênero da pessoa.
     */
    public char getGenero() {
        return genero;
    }

    /**
     * Define o gênero da pessoa.
     * @param genero Gênero da pessoa.
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }
}