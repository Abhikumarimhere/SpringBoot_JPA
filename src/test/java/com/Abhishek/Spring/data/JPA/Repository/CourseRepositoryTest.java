package com.Abhishek.Spring.data.JPA.Repository;

import com.Abhishek.Spring.data.JPA.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private  CourseRepository courseRepository;

    @Test
    public void saveCourse(){
        Course course=Course.builder()
                .title("Mathematics 001")
                .credit(500)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void getAllCourses(){
        List<Course> courseList=
                courseRepository.findAll();

        System.out.println(courseList);
    }
    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher=Teacher.builder()
                .firstName("Harrwinder")
                .lastName("singh")
                .build();
        Course course=Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }


@Test
    public void addCoursesWithStuTEA(){
        Teacher teacher=Teacher.builder()
                .firstName("Ben")
                .lastName("cutting")
                .build();
        Student1 student1=Student1.builder()
                .EmailId("Karanveer@gmail.com")
                .firstName("karan veer")
                .lastName("Mehra")
                .build();
        Course course=Course.builder()
                .title("AI")
                .credit(7)
                .teacher(teacher)
                .build();

        course.addStudents(student1);
        courseRepository.save(course);
    }


    @Test
    public void saveAll(){
        Teacher teacher=Teacher.builder()
                .firstName("Sunil")
                .lastName("sarkar")
                .build();
        CourseMaterial1 courseMaterial1=CourseMaterial1.builder()
                .Url("www.GeeksForGeeks.com")
                .build();
        Guardian guardian=Guardian.builder()
                .name("Antala")
                .email("antal@antala")
                .Mobile("12345")
                .build();
        Student1 student1=Student1.builder()
                .gaurdian(guardian)
                .EmailId("RaviKisan@gmail.com")
                .firstName("Ravi")
                .lastName("Kisan")
                .build();
        Course course=Course.builder()
                .title("CSE")
                .credit(20)
                .teacher(teacher)
                .courseMaterial1(courseMaterial1)
                .build();
        course.addStudents(student1);

        courseRepository.save(course);
    }
}