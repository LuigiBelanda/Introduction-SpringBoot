package com.compassuol.springcoredemo.common;

import org.springframework.stereotype.Component;

// Essa annotation @Component marca que esta classe é um Spring Bean
@Component
public class CricketCoach implements Coach {

    // Netse caso por estarmos usando o implements
    // Estamos pegando da nossa interface Coach alguns
    // Métodos que devemos implementar aqui nesta classe
    // E devemos sobrescrever o original, por isso
    // Usamos o Overrride
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
