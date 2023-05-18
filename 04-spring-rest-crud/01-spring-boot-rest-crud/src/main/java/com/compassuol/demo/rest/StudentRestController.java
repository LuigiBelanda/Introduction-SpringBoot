package com.compassuol.demo.rest;

import com.compassuol.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

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

    // Define endpoint or "/students/{studentId}" - return student at index
    /*
    *   Aqui como temos uma variável sendo passada na URL de request
    *   Temos que tratar isso e ver o que vamos fazer
    *   No caso a nossa URL a variável está identificada como {studentId}
    *   Então iremos receber um int na request "/students/1"
    *   Para isso no nosso método temos que usar a nossa annotation @PathVariable
    *   Dizer de qual tipo ela é e usar o MESMO NOME que usamos no @GetMapping para a variável
    *
    *   {studentId} - URL param
    *   int studentId - Method parma
    *
    *   Note que o nome de ambos os params é igual e deve ser assim
    *   Por fim neste caso iremos retornar apenas os dados do Student
    *   Que tiver o ID na List igual ao que foi enviado na request
    */
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        // Aqui verificamos se o Id existe ou não, se ele estiver fora
        // Do tamanho da List, ele já não existe neste caso
        if ((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }
}
