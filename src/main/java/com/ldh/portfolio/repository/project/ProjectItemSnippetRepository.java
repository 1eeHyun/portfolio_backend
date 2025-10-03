package com.ldh.portfolio.repository.project;

import com.ldh.portfolio.domain.project.ProjectItem;
import com.ldh.portfolio.domain.project.ProjectItemSnippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectItemSnippetRepository extends JpaRepository<ProjectItemSnippet, Long> {

    List<ProjectItemSnippet> findByProjectItemIdOrderByDisplayOrderAsc(Long itemId);
    void deleteByProjectItemId(Long itemId);
    void deleteByProjectItem(ProjectItem projectItem);
}
