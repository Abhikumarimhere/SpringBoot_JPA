package com.Abhishek.Spring.data.JPA.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Course{

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseid;
    private  String title;
    private Integer credit;


    @OneToOne(
            cascade = CascadeType.ALL,
            mappedBy = "course"
    )
    private CourseMaterial1 courseMaterial1;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherID"
    )
    private Teacher teacher;


    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "student_courses_mapping",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseid"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    private List<Student1> students;

    public void addStudents(Student1 student1){
        if(students==null)students=new ArrayList<>();
        students.add(student1);
    }
}
