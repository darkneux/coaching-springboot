package com.darkneux.coaching.config;

import com.darkneux.coaching.tempEntity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfiguration {
    @Bean
    public List<Student> studentList(){
        return new ArrayList<Student>();
    }
}
