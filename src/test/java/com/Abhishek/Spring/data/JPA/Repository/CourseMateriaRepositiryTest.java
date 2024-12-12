package com.Abhishek.Spring.data.JPA.Repository;

import com.Abhishek.Spring.data.JPA.entity.Course;
import com.Abhishek.Spring.data.JPA.entity.CourseMaterial1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMateriaRepositiryTest {
    @Autowired
    private CourseMaterialRepositiry courseMaterialRepositiry;
    @Test
    public void saveCourseMaterial(){
        Course course1=Course.builder()
                .title("English Speaking 002")
                .credit(2)
                .build();
        CourseMaterial1 courseMaterial= CourseMaterial1.builder()
                .Url("www.mymaths.com")
                .course(course1)
                .build();

        courseMaterialRepositiry.save(courseMaterial);
    }

    @Test
    public void updateurlById(){
        courseMaterialRepositiry.updateUrlById("www.English.com",3L);
    }


    @Test
    public void GetAllCourses(){
        List<CourseMaterial1> list=courseMaterialRepositiry.findAll();
        System.out.println(list);
    }
}