package com.ldh.portfolio.repository.project;

import com.ldh.portfolio.domain.project.ProjectDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDetailRepository extends JpaRepository<ProjectDetail, Long> {
    List<ProjectDetail> findByProjectId(Long projectId);
}
