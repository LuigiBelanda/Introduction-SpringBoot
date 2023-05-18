package com.compassuol.cruddemo.service;

import com.compassuol.cruddemo.dao.EmployeeDAO;
import com.compassuol.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
*   A anotação Spring @Service é usada com classes que fornecem algumas funcionalidades de negócios.
*   Essa anotação serve como uma especialização de @Component, permitindo que as classes de implementação
*   sejam detectadas automaticamente por meio da varredura de caminho de classe.
*/
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    /*
    *   Repare que ambos os métodos abaixo tem agora o @Trasanctional
    *   Isso antes ficava no nosso DAO
    *   Mas com a camada de service criada é uma boa prática essa annotation
    *   Ficar aqui neste métodos e não no DAO
    */
    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}
