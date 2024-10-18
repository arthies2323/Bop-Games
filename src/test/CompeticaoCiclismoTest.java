package test;

import ProgramacaoModular.CompeticaoCiclismo;
import ProgramacaoModular.model.Ciclista;
import ProgramacaoModular.model.Etapa;
import ProgramacaoModular.utils.Data;
import ProgramacaoModular.utils.Duracao;
import ProgramacaoModular.utils.Hora;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompeticaoCiclismoTest {
    private CompeticaoCiclismo competicao;
    private Ciclista ciclista1;
    private Ciclista ciclista2;

    @BeforeEach
    void setUp() {
        competicao = new CompeticaoCiclismo();
        ciclista1 = new Ciclista(1, "João Silva", "São Paulo");
        ciclista2 = new Ciclista(2, "Maria Oliveira", "Rio de Janeiro");

        competicao.adicionarCiclista(ciclista1);
        competicao.adicionarCiclista(ciclista2);
    }

    @Test
    void testAdicionarCiclista() {
        assertEquals(2, competicao.getCiclistas().size(), "Deve haver 2 ciclistas na competição");
    }

    @Test
    void testGetVencedor() {
        // Adicionar etapas com durações para ciclistas
        Data data = new Data(1, 7, 2023);
        Hora hora = new Hora(8, 0, 0);
        Duracao duracao1 = new Duracao(3, 30, 0);
        Duracao duracao2 = new Duracao(4, 15, 0);

        ciclista1.adicionarEtapa(new Etapa(1, data, hora, duracao1));
        ciclista2.adicionarEtapa(new Etapa(1, data, hora, duracao2));

        Ciclista vencedor = competicao.getVencedor();
        assertEquals(ciclista1, vencedor, "João deve ser o vencedor da competição");
    }

    @Test
    void testGetDiferencaTempo() {
        // Adicionar etapas com durações
        Data data = new Data(1, 7, 2023);
        Hora hora = new Hora(8, 0, 0);
        Duracao duracao1 = new Duracao(3, 30, 0);
        Duracao duracao2 = new Duracao(4, 15, 0);

        ciclista1.adicionarEtapa(new Etapa(1, data, hora, duracao1));
        ciclista2.adicionarEtapa(new Etapa(1, data, hora, duracao2));

        Duracao diferenca = competicao.getDiferencaTempo(ciclista1, ciclista2);
        assertEquals(new Duracao(0, 45, 0), diferenca, "A diferença de tempo deve ser de 45 minutos");
    }

    @Test
    void testGetVencedorEtapa() {

        Data data = new Data(1, 7, 2023);
        Hora hora = new Hora(8, 0, 0);
        Duracao duracao1 = new Duracao(3, 30, 0);
        Duracao duracao2 = new Duracao(4, 15, 0);

        ciclista1.adicionarEtapa(new Etapa(1, data, hora, duracao1));
        ciclista2.adicionarEtapa(new Etapa(1, data, hora, duracao2));

        Ciclista vencedorEtapa = competicao.getVencedorEtapa(1);
        assertEquals(ciclista1, vencedorEtapa, "João deve ser o vencedor da etapa 1");
    }
}
