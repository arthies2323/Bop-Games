package ProgramacaoModular.tp1.model;

public class Ciclista extends Participante {
    private Etapa[] etapas;
    private int etapasRegistradas;

    public Ciclista(int numero, String nome, String cidadeOrigem) {
        super(numero, nome, cidadeOrigem);
        this.etapas = new Etapa[21];
        this.etapasRegistradas = 0;
    }

    public void adicionarEtapa(Etapa etapa) {
        if (etapasRegistradas < 21) {
            etapas[etapasRegistradas++] = etapa;
        }
    }

    public Duracao getTempoTotal() {
        Duracao total = new Duracao(0, 0, 0);
        for (Etapa etapa : etapas) {
            if (etapa != null) {
                total = total.somar(etapa.getDuracao());
            }
        }
        return total;
    }

    public Duracao compararCom(Ciclista outro) {
        return this.getTempoTotal().subtrair(outro.getTempoTotal());
    }

    public boolean venceuEtapa(Ciclista outro, int numeroEtapa) {
        if (numeroEtapa < 1 || numeroEtapa > 21) {
            throw new IllegalArgumentException("Número de etapa inválido");
        }
        return this.etapas[numeroEtapa - 1].getDuracao().compareTo(outro.etapas[numeroEtapa - 1].getDuracao()) < 0;
    }
}