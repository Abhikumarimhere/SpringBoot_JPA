package com.Abhishek.Spring.data.JPA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {


    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long teacherID;
    private String firstName;
    private String lastName;

    //Since one teacher can teach many courses so teahcer and courses is having one-many relationship
//    @OneToMany(
//            cascade = CascadeType.ALL
//
//    )
//    @JoinColumn(
//            name = "teahcer_id",
//            referencedColumnName = "teacherID"
//    )
//    private List<Course> courseList;
}
