package com.ldh.portfolio.service.project;

import com.ldh.portfolio.dto.project.request.snippet.ProjectItemSnippetDTO;

import java.util.List;

public interface ProjectItemSnippetService {

    List<ProjectItemSnippetDTO> listByItem(Long itemId);

    ProjectItemSnippetDTO create(Long itemId, ProjectItemSnippetDTO req);

    ProjectItemSnippetDTO updatePartial(Long itemId, Long snippetId, ProjectItemSnippetDTO req);

    void delete(Long itemId, Long snippetId);

    void deleteByItem(Long itemId);

    List<ProjectItemSnippetDTO> reorder(Long itemId, List<ProjectItemSnippetDTO> orders);
}
