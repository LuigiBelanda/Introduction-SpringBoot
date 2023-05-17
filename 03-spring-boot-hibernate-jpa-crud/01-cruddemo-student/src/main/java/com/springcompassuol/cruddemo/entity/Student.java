package com.springcompassuol.cruddemo.entity;

import jakarta.persistence.*;

/*
*
*   A anotação @Entity é utilizada para informar que uma classe também é uma entidade.
*   A partir disso, a JPA estabelecerá a ligação entre a entidade e uma tabela de mesmo nome no banco de dados,
*   onde os dados de objetos desse tipo poderão ser persistidos.
*   Uma entidade representa, na Orientação a Objetos, uma tabela do banco de dados,
*   e cada instância dessa entidade representa uma linha dessa tabela.
*
*   Caso a tabela possua um nome diferente, podemos estabelecer esse mapeamento com a anotação @Table
*   @Table(name="student"), se não fizermos isso o código irá interpretar que a nossa tabela no BD
*   é do mesmo nome da classe
*
*/

@Entity
@Table(name="student")
public class Student {
    // define fields
    // Com a annotation @Id identificamos esse campo / atributo como um ID na nossa tabela no BD
    // Com o @GeneratedValue(strategy = GenerationType.IDENTITY) dizemos que esse ID será gerado pelo BD
    // Com o @Column(name="id") dizemos que o nome da coluna no nosso BD é "id", caso contrário ele irá buscar um campo com o mesmo nome do atributo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;



    // define constructors
    public Student() {

    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }



    // define getters/setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    // define toString() method
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
