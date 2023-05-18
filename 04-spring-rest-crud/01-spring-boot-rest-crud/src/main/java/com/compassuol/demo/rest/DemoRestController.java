package com.compassuol.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
*
*   Com a annotation @RequestMapping("/test")
*   Todos os requests que começarem com /test
*   Vão ser encaminhados aqui
*   Depois usaremos o GetMapping para selecionar mais especificamente
*   O que o usuário quis, exemplo /test/hello
*
*/
@RestController
@RequestMapping("/test")
public class DemoRestController {
    // Caso o user acesse /test/hello iremos retornar o que está abaixo
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }
}
