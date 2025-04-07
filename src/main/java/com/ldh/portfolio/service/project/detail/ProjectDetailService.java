package com.ldh.portfolio.service.project.detail;

import com.ldh.portfolio.dto.project.detail.ProjectDetailRequestDTO;
import com.ldh.portfolio.dto.project.detail.ProjectDetailResponseDTO;

import java.util.List;

public interface ProjectDetailService {

    void addDetail(ProjectDetailRequestDTO dto);
    List<ProjectDetailResponseDTO> getDetailsByProjectId(Long projectId);
}
