package com.springcompassuol.cruddemo.dao;

import com.springcompassuol.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    // define field for entity manager
    private EntityManager entityManager;



    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }



    // read method
    @Override
    public Student findById(Integer id) {
        // Student.class - Entity class
        // id - PK
        return entityManager.find(Student.class, id);
    }



    // read all student method
    @Override
    public List<Student> findAll() {
        // Create query
        // Neste caso para realizarmos nossa query usamos o nome de nossa classe
        // E dos atributos de nossa classe e não o nome da nossa tabela no banco e seus campos
        // Por isso colocamos ali "FROM Student", pois Student é o nome da nossa Entity Class
        // Também usamos lastName em vez de last_name (como está no BD) pois aqui usamos como base
        // Os nomes dos atributos da nossa Entity Class
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        // Return query results
        return theQuery.getResultList();
    }



    @Override
    public List<Student> findByLastName(String theLastName) {
        // Create query
        // Note que usamos ":theData", isso significa um parâmetro que iremos passar depois para nossa query
        // E deixamos com os ":" para o JPQL saber que este é um parâmetro
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        // Set query parameters
        // Aqui passamos para nossa Query o deve ser colocado no lugar do :theData
        // Aqui passamos o nosso dado
        theQuery.setParameter("theData", theLastName);

        // Return query results
        return theQuery.getResultList();
    }



    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }
}
