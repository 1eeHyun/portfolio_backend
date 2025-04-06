package com.ldh.portfolio.repository;

import com.ldh.portfolio.domain.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    boolean existsByTitle(String title);
}
