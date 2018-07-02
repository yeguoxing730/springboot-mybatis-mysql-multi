package com.example.demo.dao.write;


import com.example.demo.entity.Student;


public interface StudentWriteDao {

    int delete(long id);

    int insert(Student student);

    int update(Student student);


}
