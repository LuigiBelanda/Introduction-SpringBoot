package com.springapp.myappcoursespring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Com este @RestController deixamos claro que abaxio temos um Controller Rest
@RestController
public class FunRestController {
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
