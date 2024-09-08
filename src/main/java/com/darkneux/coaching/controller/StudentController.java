package com.darkneux.coaching.controller;

import com.darkneux.coaching.service.StudentService;
import com.darkneux.coaching.tempEntity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        System.out.println(student);
        return studentService.addStudent(student);

    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        System.out.println("hi");
        System.out.println("hello");
        return studentService.getStudents();
    }

    @GetMapping("/students/{id}")
    public Student student(@PathVariable("id") Long id){
        return studentService.getStudent(id);
    }

    @DeleteMapping("/students/{id}")
    public boolean delStudent(@PathVariable("id") Long id){
        return studentService.deleteStudent(id);
    }


}
