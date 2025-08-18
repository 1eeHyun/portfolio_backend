package com.ldh.portfolio.repository.project;

import com.ldh.portfolio.domain.project.ProjectImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectImageRepository extends JpaRepository<ProjectImage, Long> {

    List<ProjectImage> findByProject_IdOrderBySortOrderAsc(Long projectItemId);

    long deleteByProject_Id(Long projectItemId);
}
