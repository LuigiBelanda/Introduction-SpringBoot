package com.compassuol.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Essa annotation @Component marca que esta classe é um Spring Bean
// Com a annotation @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) definimos
// o scope do Beans para Prototype, sendo que o default é SINGLETON
// No padrão é criado uma instância do Bean e todos os objetos / props
// Que precisarem vaõ referenciar a mesma instância
// No Prototype criamos várias instâncias de um Bean e cada um com suas referências
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("in constructor: " + getClass().getSimpleName());
    }

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
