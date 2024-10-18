package test;

import ProgramacaoModular.utils.Hora;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HoraTest {

    @Test
    void testHoraCreation() {
        Hora hora = new Hora(12, 30, 15);
        assertEquals(12, hora.getHora());
        assertEquals(30, hora.getMinuto());
        assertEquals(15, hora.getSegundo());
    }

    @Test
    void testCompareTo() {
        Hora hora1 = new Hora(12, 30, 15);
        Hora hora2 = new Hora(12, 30, 20);
        assertTrue(hora1.compareTo(hora2) < 0, "hora1 deve ser menor que hora2");
        assertTrue(hora2.compareTo(hora1) > 0, "hora2 deve ser maior que hora1");
    }
}
