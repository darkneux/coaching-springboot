package com.darkneux.coaching.service;

import com.darkneux.coaching.dto.StudentDTO;
import com.darkneux.coaching.mapper.StudentMapper;
import com.darkneux.coaching.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private List<Student> students; // Consider using a proper repository

    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        students.add(student);
        return studentMapper.toDto(student);
    }

    public List<StudentDTO> getStudents() {
        return students.stream().map(studentMapper::toDto).collect(Collectors.toList());
    }

    public StudentDTO getStudent(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .map(studentMapper::toDto)
                .findFirst()
                .orElse(null);
    }

    public boolean deleteStudent(Long id) {
        return students.removeIf(student -> student.getId().equals(id));
    }
}