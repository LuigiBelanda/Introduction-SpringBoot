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

    // Com a annotation abaixo (@Qualifier) deixamos claro qual Sptring Bean
    // Queremos usar, basicamente colocamos o nome da classe que criamos, mas com
    // A primeira letra em lower case, assim o nosso código irá direto no que queremos
    @Autowired
    public void DemoController(@Qualifier("baseballCoach") Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
