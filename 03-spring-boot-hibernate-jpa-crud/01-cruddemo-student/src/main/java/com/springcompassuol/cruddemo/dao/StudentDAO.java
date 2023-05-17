package com.springcompassuol.cruddemo.dao;

import com.springcompassuol.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);
}
