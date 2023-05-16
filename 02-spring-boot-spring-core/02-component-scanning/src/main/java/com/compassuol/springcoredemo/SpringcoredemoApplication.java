package com.compassuol.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Com o param abaixo de scanBasePackages dizemos ao Spring quais diretórios ele deve observar para iniciar
// Nossa aplicação, pois por padrão ele apenas verifica os repos da sua estrutura padrão
// Se os nossos arquivos Coach e CricketCoach estivessem em util, teriamos que colocar o param abaixo
// Para o Sptring verificar este repo também, se esses arquivos estiveerem na estrutura padrão do Spring
// Não precisamos adicionar nada
// @SpringBootApplication(scanBasePackages = {"com.compassuol.springcoredemo", "com.compassuol.util"})
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
