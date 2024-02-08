package com.lucasnogueira.onebrc.springbatch.impl;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

@Data
@Component
public class CalculoMap {

    private final Map<String, Calculo> mapa = new ConcurrentSkipListMap<>();



    public Map<String, Calculo> getMapa() {
        return mapa;
    }

    public void adicionarAoMapa(String chave, Calculo calculo) {
        mapa.put(chave, calculo);
    }
}

