package com.compassuol.cruddemo.dao;


import com.compassuol.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
