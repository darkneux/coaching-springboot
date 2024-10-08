package com.darkneux.coaching.controller;

import com.darkneux.coaching.dto.StudentDTO;
import com.darkneux.coaching.service.StudentService;
import com.darkneux.coaching.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public StudentDTO addStudent(@RequestBody StudentDTO student){
        return studentService.addStudent(student);

    }

    @GetMapping("/students")
    public List<StudentDTO> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/students/{id}")
    public StudentDTO student(@PathVariable("id") Long id){
        return studentService.getStudent(id);
    }

    @DeleteMapping("/students/{id}")
    public boolean delStudent(@PathVariable("id") Long id){
        return studentService.deleteStudent(id);
    }


}
