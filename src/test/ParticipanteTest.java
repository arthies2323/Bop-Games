package test;

import ProgramacaoModular.model.Participante;
import ProgramacaoModular.model.Ciclista; // Importando Ciclista pois Participante é abstrato
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParticipanteTest {

    @Test
    void testParticipanteCreation() {
        Participante participante = new Ciclista(1, "João Silva", "São Paulo");

        assertEquals(1, participante.getNumero());
        assertEquals("João Silva", participante.getNome());
        assertEquals("São Paulo", participante.getCidadeOrigem());
    }
}
