package com.compassuol.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
*   Por padrão, os métodos em um @ControllerAdvice se aplicam globalmente a todos os controladores.
*
*   Para a implementação da classe que gerencia todas as exceções utilizaremos a anotação @ControllerAdvice.
*   Essa anotação é do Spring Framework e
*   é utilizada para lidar com exceções lançadas em qualquer lugar da sua aplicação, não só pelo controller.
*
*   De acordo com a própria documentação do Spring, o @ControllerAdvice é uma especialização da anotação
*   @Component, que permite manipular exceções em todo o aplicativo em um component global.
*/
@ControllerAdvice
public class StudentRestExceptionHandler {
    // Add exception handling code
    // Add an exception handler using @ExceptionHandler
    /*
     *   @ExceptionHandler - Anotação para lidar com exceções em classes de manipulador específicas e/ou métodos de manipulador.
     *   ResponseEntity - Extensão de HttpEntity que adiciona um código de status HttpStatusCode. Usado em RestTemplate, bem como em métodos @Controller.
     *   ResponseEntity representa toda a resposta HTTP: código de status, cabeçalhos e corpo. Como resultado, podemos usá-lo para configurar totalmente a resposta HTTP.
     *   <StudentErrorResponse> - Tipo do corpo do response (os campos que definimos na Classe é o que iremos retornar)
     *   handleException(StudentNotFoundException exc) - Neste caso o StudentNotFoundException é o tipo de exceção que iremos lançar / tratar apenas
     */
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
        // Create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // Return ResponseEntity
        // error - body
        // HttpStatus - Status
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Add another exception handler... to catch any exceptions
    /*
     *   Podemos notar que dessa vemos usamos apenas um "Exception" para
     *   Determinar o tipo de exceção que iremos pegar / tratar
     *   No anterior tinhamos um tipo definido, StudentNotFoundException
     *   Ou seja, se uma exceção for lançada com o tipo acima
     *   Iremos mandar a mensagem que definimos acima
     *   Caso contrário, qualquer exceção que for lançada, iremos retornar uma mensagem
     *   Por meio do código abaixo
     */
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handlerException(Exception exc) {
        // Create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // Return ResponseEntity
        // error - body
        // HttpStatus - Status
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
