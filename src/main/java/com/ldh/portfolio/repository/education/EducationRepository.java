package com.ldh.portfolio.repository.education;

import com.ldh.portfolio.domain.education.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {


}
