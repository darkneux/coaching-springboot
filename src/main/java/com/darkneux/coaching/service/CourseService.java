package com.darkneux.coaching.service;

import com.darkneux.coaching.dto.CourseDTO;
import com.darkneux.coaching.mapper.CourseMapper;
import com.darkneux.coaching.model.Course;
import com.darkneux.coaching.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseRepository courseRepository;

    public CourseDTO addCourse(CourseDTO courseDTO) {
        Course course = courseMapper.toEntity(courseDTO);
        course = courseRepository.save(course);
        return courseMapper.toDto(course);
    }

    public List<CourseDTO> getCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(courseMapper::toDto).collect(Collectors.toList());
    }

    public CourseDTO getCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.map(courseMapper::toDto).orElse(null);
    }

    public boolean deleteCourse(Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
