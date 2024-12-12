package com.Abhishek.Spring.data.JPA.Repository;

import com.Abhishek.Spring.data.JPA.entity.Course;
import com.Abhishek.Spring.data.JPA.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void saveTeacher(){
        Course courseDSA=Course.builder()
                .title("DSA")
                .credit(4)
                .build();
        Course courseFrench=Course.builder()
                .title("French")
                .credit(2)
                .build();
        Course courseSQL=Course.builder()
                .title("SQL")
                .credit(5)
                .build();

        Teacher teacher=Teacher.builder()
                .firstName("Dinesh")
                .lastName("Mishra")
                //.courseList(List.of(courseDSA,courseSQL,courseFrench))
                .build();

        teacherRepository.save(teacher);
    }


}