package com.darkneux.coaching.tempEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class Student {
    private Long id;
    private String fname;
    private String sname;
    private List<Course> courses;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", sname='" + sname + '\'' +
                ", courses=" + courses +
                '}';
    }
}
