package com.darkneux.coaching.service;

import com.darkneux.coaching.tempEntity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class StudentService {

    @Autowired
    List<Student> students;

    public Student addStudent(Student student){
        students.add(student);
        return student;
    }

    public List<Student> getStudents(){
        return students;
    }

    public Student getStudent(Long id){
        Student student = null;
        for(Student st : students){
            if(st.getId() == id ){
                student = st;
                break;
            }
        }
        
        return student;
    }


    public boolean deleteStudent(Long id){
        Iterator<Student> iterator = students.iterator();

        while(iterator.hasNext()){
            Student student = iterator.next();
            if(Objects.equals(student.getId(), id)){
                iterator.remove();
                return true;
            }
        }
      return false;
    }

}
