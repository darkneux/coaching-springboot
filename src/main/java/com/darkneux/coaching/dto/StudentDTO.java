package com.darkneux.coaching.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class StudentDTO {
    private Long id;
    private String fname;
    private String sname;
    private List<CourseDTO> courses;
}