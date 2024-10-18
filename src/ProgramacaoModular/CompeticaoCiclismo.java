package ProgramacaoModular;

import ProgramacaoModular.model.Ciclista;
import ProgramacaoModular.utils.Duracao;

import java.util.ArrayList;
import java.util.List;

public class CompeticaoCiclismo {
    private List<Ciclista> ciclistas;

    public CompeticaoCiclismo() {
        this.ciclistas = new ArrayList<>();
    }

    public void adicionarCiclista(Ciclista ciclista) {
        ciclistas.add(ciclista);
    }

    public Ciclista getVencedor() {
        if (ciclistas.isEmpty()) {
            return null;
        }
        Ciclista vencedor = ciclistas.get(0);
        for (Ciclista ciclista : ciclistas) {
            if (ciclista.getTempoTotal().compareTo(vencedor.getTempoTotal()) < 0) {
                vencedor = ciclista;
            }
        }
        return vencedor;
    }

    public Duracao getDiferencaTempo(Ciclista ciclista1, Ciclista ciclista2) {
        return ciclista1.getTempoTotal().subtrair(ciclista2.getTempoTotal());
    }

    public Ciclista getVencedorEtapa(int numeroEtapa) {
        if (ciclistas.isEmpty()) {
            return null;
        }
        Ciclista vencedor = ciclistas.get(0);
        for (Ciclista ciclista : ciclistas) {
            if (ciclista.venceuEtapa(vencedor, numeroEtapa)) {
                vencedor = ciclista;
            }
        }
        return vencedor;
    }

    public List<Ciclista> getCiclistas() {
        return ciclistas;
    }
}