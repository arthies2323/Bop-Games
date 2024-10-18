package test;

import ProgramacaoModular.utils.Duracao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuracaoTest {

    @Test
    void testDuracaoCreation() {
        Duracao duracao = new Duracao(2, 30, 45);
        assertEquals(2, duracao.getHoras());
        assertEquals(30, duracao.getMinutos());
        assertEquals(45, duracao.getSegundos());
    }

    @Test
    void testSomar() {
        Duracao duracao1 = new Duracao(1, 30, 30);
        Duracao duracao2 = new Duracao(1, 45, 50);
        Duracao resultado = duracao1.somar(duracao2);
        assertEquals(3, resultado.getHoras());
        assertEquals(16, resultado.getMinutos());
        assertEquals(20, resultado.getSegundos());
    }

    @Test
    void testSubtrair() {
        Duracao duracao1 = new Duracao(3, 30, 0);
        Duracao duracao2 = new Duracao(2, 45, 0);
        Duracao resultado = duracao1.subtrair(duracao2);
        assertEquals(0, resultado.getHoras());
        assertEquals(45, resultado.getMinutos());
        assertEquals(0, resultado.getSegundos());
    }

    @Test
    void testCompareTo() {
        Duracao duracao1 = new Duracao(1, 30, 0);
        Duracao duracao2 = new Duracao(2, 15, 0);
        assertTrue(duracao1.compareTo(duracao2) < 0, "duracao1 deve ser menor que duracao2");
        assertTrue(duracao2.compareTo(duracao1) > 0, "duracao2 deve ser maior que duracao1");
    }
}
