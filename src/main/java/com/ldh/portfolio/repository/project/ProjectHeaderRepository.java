package com.ldh.portfolio.repository.project;

import com.ldh.portfolio.domain.project.ProjectHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectHeaderRepository extends JpaRepository<ProjectHeader, Long> {

    List<ProjectHeader> findAllByOrderByYearDescSortOrderAscIdDesc();
}
