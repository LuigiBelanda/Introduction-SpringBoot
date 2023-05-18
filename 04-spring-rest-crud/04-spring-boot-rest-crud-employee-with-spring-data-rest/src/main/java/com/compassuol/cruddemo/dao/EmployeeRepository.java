package com.compassuol.cruddemo.dao;

import com.compassuol.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// EmployeeRepository - Repository
// Employee - Type Entity
// Integer - PK
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
