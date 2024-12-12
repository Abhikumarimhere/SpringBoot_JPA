package com.Abhishek.Spring.data.JPA.Repository;

import com.Abhishek.Spring.data.JPA.entity.Student1;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRespository extends JpaRepository<Student1,Long> {
    public List<Student1> findByFirstName(String firstName);
    public List<Student1> findByFirstNameContaining(String name);

    public List<Student1> findByGaurdianName(String name);
    @Query("select s from Student1 s where s.EmailId=?1")
    Student1 getStudentByEmailAddress(String emailID);
    @Query("select s.firstName from Student1 s where s.EmailId=?1")
    String getStudentFNByEmailAddress(String emailID);

    @Query(
           value = "Select s.first_Name from tbl_student s where s.email_address=?1",
            nativeQuery = true
    )
    String getStudentFNByEmailAddressNative(String emailID);
    @Query(
            value = "Select s.first_Name from tbl_student s where s.email_address=:EmailID",
            nativeQuery = true
    )
    String getStudentFNByEmailAddressNativeNamed(@Param("EmailID") String emailID);
@Modifying
@Transactional
    @Query(
            value = "update tbl_student set first_Name=?1 where email_address=?2",
            nativeQuery = true
    )
    int updateFirstNameByEmail(String firstName,String EmailId);
}


