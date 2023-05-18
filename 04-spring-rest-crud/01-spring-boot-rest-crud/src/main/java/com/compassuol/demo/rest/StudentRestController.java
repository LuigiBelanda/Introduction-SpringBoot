package com.compassuol.demo.rest;

import com.compassuol.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private  List<Student> theStudents;

    /*
    *   Define @PostConstruct to load the student data... only once!
    *   Assim que o Spring começar a gerenciar esse Bean / Class (StudentRestController)
    *   E Instanciar ele, após esse processo, é chamado nosso @PostConstruct que irá
    *   Executar o código que desejamos
    */
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Porrnima", "Patel"));
        theStudents.add(new Student("Mario", "Rossi"));
        theStudents.add(new Student("Mary", "Smith"));
    }


    /*
    *   Aqui nosso REST Service irá retornar uma List de students
    *   Algo que não conseguimos passar direto para nosso REST Cliente (quem fez a request)
    *   Então é aqui que entra o Jackson (o Spring e o Jackson Trabalham juntos),
    *   onde ele converte a nossa List em JSON, mais
    *   Especificamente POJO -> JSON e ai sim envia esses dados para quem fez a request
    */
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }
}
