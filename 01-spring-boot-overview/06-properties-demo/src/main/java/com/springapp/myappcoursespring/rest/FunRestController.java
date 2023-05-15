package com.springapp.myappcoursespring.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Com este @RestController deixamos claro que abaxio temos um Controller Rest
@RestController
public class FunRestController {
    // Inject properties for: coach.name and team.name (application.properties)
    // Com a anotação @Value conseguimos pegar algum propriedade
    // Do nosso arquivo application.properties
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // Expose new endpoint for "teaminfo"
    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + " Team: " + teamName;
    }



    // expose "/" that return "Hello World"
    // Este @GetMapping é na realidade uma notação para o
    // mapeamento de solicitações HTTP GET
    // Aqui em específico quando o usuário fazer um get na rota "/"
    // Ele irá chamar a função abaixo e retornar o que queremos
    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }



    // Expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 10k!";
    }



    // Expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your luck day";
    }
}
