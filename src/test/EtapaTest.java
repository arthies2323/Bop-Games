package test;

import ProgramacaoModular.model.Etapa;
import ProgramacaoModular.utils.Data;
import ProgramacaoModular.utils.Duracao;
import ProgramacaoModular.utils.Hora;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EtapaTest {

    @Test
    void testEtapaCreation() {
        Data data = new Data(1, 7, 2023);
        Hora hora = new Hora(8, 0, 0);
        Duracao duracao = new Duracao(3, 30, 0);
        Etapa etapa = new Etapa(1, data, hora, duracao);

        assertEquals(1, etapa.getNumero());
        assertEquals(data, etapa.getData());
        assertEquals(hora, etapa.getHoraInicial());
        assertEquals(duracao, etapa.getDuracao());
    }
}

