package com.ldh.portfolio.service;

import com.ldh.portfolio.dto.ProjectResponseDTO;

import java.util.List;

public interface ProjectService {

    List<ProjectResponseDTO> getAllProjects();
    ProjectResponseDTO getProjectById(Long id);
}
