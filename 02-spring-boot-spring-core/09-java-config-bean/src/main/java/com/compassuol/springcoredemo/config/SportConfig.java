package com.compassuol.springcoredemo.config;

import com.compassuol.springcoredemo.common.Coach;
import com.compassuol.springcoredemo.common.SwinCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// A annontation abaixo @Configuration mostra que está é uma classe de configuração
@Configuration
public class SportConfig {
    /*
    Com a annotation @Bean deixamos claro que este também é um Bean que o Spring
    Deve tomar conta, usamos o @Bean normalmente para métodos / classes de terceiros
    Quando não conseguimos usar o @Component

    Por padrão, beans que usam @Bean são criados dentro de classes do tipo @Configuration

    No caso abaixo o nome do nosso método (swimCoach) é o nome do nosso Bean ID
     */
    @Bean
    public Coach swimCoach() {
        return new SwinCoach();
    }
}
