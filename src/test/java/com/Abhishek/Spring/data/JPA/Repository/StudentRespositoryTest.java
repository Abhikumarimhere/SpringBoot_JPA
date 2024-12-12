package com.Abhishek.Spring.data.JPA.Repository;


import com.Abhishek.Spring.data.JPA.entity.Guardian;
import com.Abhishek.Spring.data.JPA.entity.Student1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentRespositoryTest {
    @Autowired
    private StudentRespository studentRespository;

    @Test
    public void saveStudent(){
      Student1 student= Student1.builder()
                .EmailId("abhi@ok")
                .firstName("Abhishek")
                .lastName("kumar")
                .build();
        studentRespository.save(student);
    }

    @Test
    public void saveWithgaurdian(){
        Guardian gaurdian1=Guardian.builder()
                .email("nk@ok")
                .name("narendra")
                .Mobile("123")
                .build();
        Student1 student=Student1.builder()
                .EmailId("Ankittrue@gmail")
                .firstName("Ankit")
                .lastName("kumar")
                .gaurdian(gaurdian1)
                .build();

        studentRespository.save(student);
    }
    @Test
    public void printAllStudent(){
        List<Student1> StudentList=studentRespository.findAll();

        System.out.println(StudentList);
    }

    @Test
    public void printAllByName(){
        List<Student1> list=studentRespository.findByFirstName("Ankit");
        System.out.println(list);
    }

    @Test
    public void printAllByNamecont(){
        List<Student1> list=studentRespository.findByFirstNameContaining("A");
        System.out.println(list);
    }
    @Test
    public void printAllByGuardianNamecont(){
        List<Student1> list=studentRespository.findByGaurdianName("narendra");
        System.out.println(list);
    }

    @Test
    public void getStudentByemail(){
        Student1 list=studentRespository.getStudentByEmailAddress("abhi@ok");
        System.out.println(list);
    }
    @Test
    public void getStudentFNByemail(){
        String list=studentRespository.getStudentFNByEmailAddress("abhi@ok");
        System.out.println(list);
    }
    @Test
    public void getStudentFUNByemail(){
        String list=studentRespository.getStudentFNByEmailAddressNative("Ankittrue@gmail");
        System.out.println(list);
    }
    @Test
    public void getStudentFUNByemailnamed(){
        String list=studentRespository.getStudentFNByEmailAddressNativeNamed("Ankittrue@gmail");
        System.out.println(list);
    }

    @Test
    public void updateFirstNameBYemail(){
       studentRespository.updateFirstNameByEmail("Golu","Ankittrue@gmail");
    }
}