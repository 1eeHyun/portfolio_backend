package com.ldh.portfolio.repository.project;

import com.ldh.portfolio.domain.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    boolean existsByTitle(String title);
}
