package com.example.demo.dao.read;


import com.example.demo.entity.Student;

import java.util.List;


public interface StudentReadDao {

    List<Student> getStudentList();

    Student getById(long id);

}
