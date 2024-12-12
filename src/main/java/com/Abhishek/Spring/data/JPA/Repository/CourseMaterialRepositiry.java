package com.Abhishek.Spring.data.JPA.Repository;

import com.Abhishek.Spring.data.JPA.entity.CourseMaterial1;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepositiry extends JpaRepository<CourseMaterial1,Long> {
    @Modifying
    @Transactional
    @Query(
            value = "update course_material1 set url=?1 where course_id=?2",
            nativeQuery = true
    )
     int updateUrlById(String url,Long Id);
}
