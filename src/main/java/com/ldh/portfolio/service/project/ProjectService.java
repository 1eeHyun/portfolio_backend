package com.ldh.portfolio.service.project;

import com.ldh.portfolio.dto.project.ProjectRequestDTO;
import com.ldh.portfolio.dto.project.ProjectResponseDTO;

import java.util.List;

public interface ProjectService {

    List<ProjectResponseDTO> getAllProjects();
    ProjectResponseDTO getProjectById(Long id);
    ProjectResponseDTO createProject(ProjectRequestDTO dto);
}
