package com.ldh.portfolio.service;

import com.ldh.portfolio.builder.ProjectResponseBuilder;
import com.ldh.portfolio.dto.ProjectResponseDTO;
import com.ldh.portfolio.repository.ProjectRepository;
import com.ldh.portfolio.validator.ProjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectResponseBuilder responseBuilder;
    private final ProjectValidator projectValidator;

    @Override
    public List<ProjectResponseDTO> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(responseBuilder::toDTO)
                .toList();
    }

    @Override
    public ProjectResponseDTO getProjectById(Long id) {
        return projectRepository.findById(id)
                .map(responseBuilder::toDTO)
                .orElseThrow(() -> new RuntimeException("Project not found: " + id));
    }
}
