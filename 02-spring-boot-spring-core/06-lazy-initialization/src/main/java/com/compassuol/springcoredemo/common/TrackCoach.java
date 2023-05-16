package com.compassuol.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

// Com a annontation @Lazy basicamente deixamos claro para o Spring só inicializar
// Este Bean se ele for necessário em uma injeção de dependência ou algo do tipo
// pois por padrão o Spring inicializa todos os Beans e cria uma instância deles
// Assim que o projeto da Build, com o @Lazy isso não ocorre, só será instanciado
// Se for chamado / usado
@Component
@Lazy
public class TrackCoach implements Coach {
    public TrackCoach() {
        System.out.println("in constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }
}
