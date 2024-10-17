package ProgramacaoModular.model;

public abstract class Participante {
    private int numero;
    private String nome;
    private String cidadeOrigem;

    public Participante(int numero, String nome, String cidadeOrigem) {
        this.numero = numero;
        this.nome = nome;
        this.cidadeOrigem = cidadeOrigem;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public String getCidadeOrigem() {
        return cidadeOrigem;
    }
}