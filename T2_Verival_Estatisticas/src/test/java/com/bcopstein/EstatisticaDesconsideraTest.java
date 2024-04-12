package com.bcopstein;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EstatisticaDesconsideraTest {

    static IEventoRepository rep;
    static ICalculoEstatistica calc;
    @BeforeAll
    public static void inicializa(){
        rep = mock(IEventoRepository.class);
        calc = mock(ICalculoEstatistica.class);

        when(rep.todos()).thenReturn(Arrays.asList(
                new Evento(10,"POA Day RUN", 10, 3, 2021, 5000, 0, 43, 0),
                new Evento(12,"POA Night RUN", 15, 5, 2021, 5000, 0, 42,0),
                new Evento(11,"NIKE RUN", 17, 6, 2021, 21000, 1, 22,0),
                new Evento(14,"SUMMER RUN", 22, 8, 2021, 5000, 0, 41, 0),
                new Evento(16,"SPRING RUN", 22, 8, 2021, 5000, 0, 41, 30),
                new Evento(18,"WINTER RUN", 2, 8, 2021, 5000, 0, 42, 30)));

    }
    @Test
    void calculaEstatisticas() {
        EstatisticaDesconsidera en = new EstatisticaDesconsidera(rep);

        EstatisticasDTO resp = en.calculaEstatisticas(21000);
        assertEquals(4920,resp.getMedia());
        assertEquals(4920,resp.getMediana());
        assertEquals(0,resp.getDesvioPadrao());
    }
}