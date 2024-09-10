package com.darkneux.coaching.mapper;

import com.darkneux.coaching.dto.CourseDTO;
import com.darkneux.coaching.model.Course;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CourseDTO toDto(Course course) {
        return modelMapper.map(course, CourseDTO.class);
    }

    public Course toEntity(CourseDTO dto) {
        return modelMapper.map(dto, Course.class);
    }
}