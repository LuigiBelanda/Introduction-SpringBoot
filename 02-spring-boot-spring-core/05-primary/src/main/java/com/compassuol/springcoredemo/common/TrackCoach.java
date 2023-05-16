package com.compassuol.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// Com a annotation abaixo @Primary, caso tenhamos mais de um Spring Bean
// Não precisamos colocar o @Qualifier, basicamente dizemos que caso não tenhamos
// Nenhuma especificação de qual Bean devemos pegar, usaremos esse com o @Primary
// Só podemos ter um Bean com o @Primary e o @Qualifier tem maior valor, ou seja,
// O nosso código optara por usar o que dissemos no @Qualifier em vez do @Primary sempre que
// Possível, só depois do @Qualifier ele vem para o @Primary
@Component
@Primary
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }
}
