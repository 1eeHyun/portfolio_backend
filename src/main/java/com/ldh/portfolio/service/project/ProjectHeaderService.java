package com.ldh.portfolio.service.project;

import com.ldh.portfolio.dto.project.ProjectHeaderDetailDTO;
import com.ldh.portfolio.dto.project.ProjectHeaderListItemDTO;
import com.ldh.portfolio.dto.project.request.ProjectHeaderCreateRequest;
import com.ldh.portfolio.dto.project.request.ProjectHeaderUpdateRequest;

import java.util.List;

public interface ProjectHeaderService {

    List<ProjectHeaderListItemDTO> listHeaders();

    ProjectHeaderDetailDTO headerDetail(Long headerId);

    Long createHeader(ProjectHeaderCreateRequest req);

    void updateHeader(Long headerId, ProjectHeaderUpdateRequest req);
}
