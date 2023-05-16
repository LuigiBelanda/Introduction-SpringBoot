package com.compassuol.springcoredemo.rest;

import com.compassuol.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // Define a private field for the dependency
    private Coach myCoach;

    // Por padrão os Beans são SINGLETON
    // Ou seja, é criada apenas um instância deles e se
    // Usarmos mais de um Bean do mesmo tipo, ambos
    // Vão referenciar a mesma instância criado ao inicializar o app
    @Autowired
    public void DemoController(@Qualifier("cricketCoach") Coach theCoach) {
        System.out.println("in constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
