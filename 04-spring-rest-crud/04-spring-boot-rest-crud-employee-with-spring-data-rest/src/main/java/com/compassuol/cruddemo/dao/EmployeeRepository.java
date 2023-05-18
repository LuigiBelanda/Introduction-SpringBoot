package com.compassuol.cruddemo.dao;

import com.compassuol.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// EmployeeRepository - Repository
// Employee - Type Entity
// Integer - PK

// Com o @RepositoryRestResource podemos definir um novo nome para nosso endpoint
// Em vez dele usar como base nossa Entity Name
// Então nosso endpoint padrão agora é: /members
// @RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
