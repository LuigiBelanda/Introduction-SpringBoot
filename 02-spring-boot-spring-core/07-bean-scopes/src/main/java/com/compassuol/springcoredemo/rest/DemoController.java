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
    private Coach anotherCoach;

    // Por padrão os Beans são SINGLETON
    // Ou seja, é criada apenas um instância deles e se
    // Usarmos mais de um Bean do mesmo tipo, ambos
    // Vão referenciar a mesma instância criado ao inicializar o app
    @Autowired
    public void DemoController(
            @Qualifier("cricketCoach") Coach theCoach,
            @Qualifier("cricketCoach") Coach thAnotherCoach) {
        System.out.println("in constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = thAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    // Basicamente esta roda irá serbir para vermos se estamos usando a mesma
    // Referência do Bean instânciado
    // Se der TRUE estamos usando a mesma instância (SINGLETON - default scope)
    // Caso der FALSE, são diferentes (PROTOTYPE)
    @GetMapping("/check")
    public String check() {
        return "Comparing Beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}
