package com.example.demo.controller;

import com.example.demo.dao.read.StudentReadDao;
import com.example.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/student")
public class StudentController {


    @Resource
    StudentReadDao studentReadDao;


    @GetMapping("/getById/{id}/")
    public Student getById(@PathVariable("id")long id){
        Student student=studentReadDao.getById(id);
        return student;
    }


}
