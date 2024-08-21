package com.example.school.Repository;

import com.example.school.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT t FROM Teacher t WHERE t.Name LIKE %:keyword%")
    List<Teacher> searchByKeyword(@Param("keyword") String keyword);
}
