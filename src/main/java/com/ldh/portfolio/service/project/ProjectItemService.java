package com.ldh.portfolio.service.project;

import com.ldh.portfolio.domain.project.ProjectItem;
import com.ldh.portfolio.dto.project.ProjectItemDetailDTO;
import com.ldh.portfolio.dto.project.request.ProjectItemCreateRequest;
import com.ldh.portfolio.dto.project.request.ProjectItemUpdateRequest;

import java.util.List;

public interface ProjectItemService {

    List<ProjectItem> listByHeader(Long headerId);
    ProjectItemDetailDTO detail(Long itemId);
    Long create(ProjectItemCreateRequest req);

    void update(Long itemId, ProjectItemUpdateRequest req);
}
