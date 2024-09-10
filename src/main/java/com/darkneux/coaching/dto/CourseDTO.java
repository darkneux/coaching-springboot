package com.darkneux.coaching.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseDTO {
    private Long id;
    private String name;
    private int duration;
}