package com.darkneux.coaching.mapper;


import com.darkneux.coaching.dto.StudentDTO;
import com.darkneux.coaching.model.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    @Autowired
    private ModelMapper modelMapper;

    public StudentDTO toDto(Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }

    public Student toEntity(StudentDTO dto) {
        return modelMapper.map(dto, Student.class);
    }
}