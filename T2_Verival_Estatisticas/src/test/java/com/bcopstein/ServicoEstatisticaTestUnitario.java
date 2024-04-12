package com.bcopstein;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServicoEstatisticaTestUnitario {
    static IEventoRepository rep;
    static ICalculoEstatistica stats;
    static ServicoEstatistica service;
    @BeforeAll
    public static void inicializa(){
        rep = mock(IEventoRepository.class);
        when(rep.todos()).thenReturn(Arrays.asList(
          new Evento(10,"POA Day RUN", 10, 3, 2021, 5000, 0, 43, 0),
          new Evento(12,"POA Night RUN", 15, 5, 2021, 5000, 0, 42,0),
          new Evento(11,"NIKE RUN", 17, 6, 2021, 21000, 1, 22,0),
          new Evento(14,"SUMMER RUN", 22, 8, 2021, 5000, 0, 41, 0),
          new Evento(16,"SPRING RUN", 22, 8, 2021, 5000, 0, 41, 30),
          new Evento(18,"WINTER RUN", 2, 8, 2021, 5000, 0, 42, 30)));

        stats = mock(ICalculoEstatistica.class);
        service = new ServicoEstatistica(rep,stats);
    }

    @Test
    void calculaEstatisticas() {
        when(service.calculaEstatisticas(15)).
                thenReturn(new EstatisticasDTO(5,10,15));

        EstatisticasDTO ret = service.calculaEstatisticas(15);

        assertEquals(5,ret.getMedia());
        assertEquals(10,ret.getMediana());
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