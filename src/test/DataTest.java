package test;

import ProgramacaoModular.utils.Data;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    @Test
    void testDataCreation() {
        Data data = new Data(1, 7, 2023);
        assertEquals(1, data.getDia());
        assertEquals(7, data.getMes());
        assertEquals(2023, data.getAno());
    }
}
