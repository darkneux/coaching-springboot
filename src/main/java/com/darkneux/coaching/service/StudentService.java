package com.darkneux.coaching.service;

import com.darkneux.coaching.dto.StudentDTO;
import com.darkneux.coaching.mapper.StudentMapper;
import com.darkneux.coaching.model.Student;
import com.darkneux.coaching.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentRepository studentRepository;

    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        student = studentRepository.save(student);
        return studentMapper.toDto(student);
    }

    public List<StudentDTO> getStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(studentMapper::toDto).collect(Collectors.toList());
    }

    public StudentDTO getStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.map(studentMapper::toDto).orElse(null);
    }

    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
