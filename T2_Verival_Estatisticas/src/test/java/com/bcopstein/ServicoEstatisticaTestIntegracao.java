package com.bcopstein;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServicoEstatisticaTestIntegracao {
    static IEventoRepository rep;
    static ICalculoEstatistica calc;
    static ServicoEstatistica service;
    @BeforeAll
    public static void inicializa(){
        rep = mock(IEventoRepository.class);
        calc = mock(ICalculoEstatistica.class);
        service = new ServicoEstatistica(rep,calc);

        when(rep.todos()).thenReturn(Arrays.asList(
          new Evento(10,"POA Day RUN", 10, 3, 2021, 5000, 0, 43, 0),
          new Evento(12,"POA Night RUN", 15, 5, 2021, 5000, 0, 42,0),
          new Evento(11,"NIKE RUN", 17, 6, 2021, 21000, 1, 22,0),
          new Evento(14,"SUMMER RUN", 22, 8, 2021, 5000, 0, 41, 0),
          new Evento(16,"SPRING RUN", 22, 8, 2021, 5000, 0, 41, 30),
          new Evento(18,"WINTER RUN", 2, 8, 2021, 5000, 0, 42, 30)));

        when(calc.calculaEstatisticas(5000))
                .thenReturn(new EstatisticasDTO(50,225,15));
    }

    @Test
    void calculaEstatisticas() {
        EstatisticasDTO ret = service.calculaEstatisticas(5000);

        assertEquals(50,ret.getMedia());
        assertEquals(225,ret.getMediana());
        assertEquals(15,ret.getDesvioPadrao());
    }

    @Test
    void calculaAumentoPerformance() {
        PerformanceDTO res = service.calculaAumentoPerformance(5000,2021);

        assertEquals("NIKE RUN",res.getProva1());
        assertEquals("SUMMER RUN",res.getProva2());
        assertEquals(2460.0,res.getReducao());
    }
}