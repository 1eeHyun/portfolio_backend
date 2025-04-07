package com.ldh.portfolio.validator.project;

import com.ldh.portfolio.domain.project.Project;
import com.ldh.portfolio.dto.project.ProjectRequestDTO;
import com.ldh.portfolio.repository.project.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProjectValidator {

    private final ProjectRepository projectRepository;

    public void validateCreate(ProjectRequestDTO dto) {
        if (projectRepository.existsByTitle(dto.getTitle())) {
            throw new IllegalArgumentException("Already existed title.");
        }
    }

    public Project validateExists(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }
}
