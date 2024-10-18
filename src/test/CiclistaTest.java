package test;

import ProgramacaoModular.model.Ciclista;
import ProgramacaoModular.model.Etapa;
import ProgramacaoModular.utils.Data;
import ProgramacaoModular.utils.Duracao;
import ProgramacaoModular.utils.Hora;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CiclistaTest {
    private Ciclista ciclista;

    @BeforeEach
    void setUp() {
        ciclista = new Ciclista(1, "João Silva", "São Paulo");
    }

    @Test
    void testAdicionarEtapa() {
        Data data = new Data(1, 7, 2023);
        Hora hora = new Hora(8, 0, 0);
        Duracao duracao = new Duracao(3, 30, 0);
        Etapa etapa = new Etapa(1, data, hora, duracao);

        ciclista.adicionarEtapa(etapa);

        assertEquals(1, ciclista.getNumero(), "Deve haver uma etapa adicionada ao ciclista");
    }

    @Test
    void testGetTempoTotal() {
        // Adicionar etapas e verificar o tempo total
        Data data = new Data(1, 7, 2023);
        Hora hora = new Hora(8, 0, 0);
        Duracao duracao1 = new Duracao(3, 30, 0);
        Duracao duracao2 = new Duracao(2, 45, 0);

        ciclista.adicionarEtapa(new Etapa(1, data, hora, duracao1));
        ciclista.adicionarEtapa(new Etapa(2, data, hora, duracao2));

        Duracao tempoTotal = ciclista.getTempoTotal();

        assertEquals(new Duracao(6, 15, 0), tempoTotal, "O tempo total deve ser a soma das etapas");
    }

    @Test
    void testVenceuEtapa() {
        // Adicionar etapas e verificar se o ciclista venceu
        Data data = new Data(1, 7, 2023);
        Hora hora = new Hora(8, 0, 0);
        Duracao duracao1 = new Duracao(3, 30, 0);
        Duracao duracao2 = new Duracao(4, 15, 0);

        ciclista.adicionarEtapa(new Etapa(1, data, hora, duracao1));
        Ciclista outroCiclista = new Ciclista(2, "Maria Oliveira", "Rio de Janeiro");
        outroCiclista.adicionarEtapa(new Etapa(1, data, hora, duracao2));

        assertTrue(ciclista.venceuEtapa(outroCiclista, 1), "João deve vencer a etapa 1");
    }
}
