package com.ldh.portfolio.repository.course;

import com.ldh.portfolio.domain.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByCode(String code);
    boolean existsByCode(String code);

    /** Find a course by its unique (code, year) pair */
    Optional<Course> findByCodeAndYear(String code, Integer year);

    /** Quick existence check for (code, year) pair */
    boolean existsByCodeAndYear(String code, Integer year);
}
