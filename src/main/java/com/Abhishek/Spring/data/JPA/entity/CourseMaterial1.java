package com.Abhishek.Spring.data.JPA.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial1 {

    @Id
    @SequenceGenerator(
            name = "Course_Material_Sequence",
            sequenceName = "Course_Material_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Course_Material_Sequence"
    )
    private  Long CourseMaterialID;
    private String Url;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseid"
    )
    private Course course;
}
