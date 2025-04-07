package com.ldh.portfolio.service.project;

import com.ldh.portfolio.builder.project.ProjectResponseBuilder;
import com.ldh.portfolio.domain.project.Project;
import com.ldh.portfolio.dto.project.ProjectRequestDTO;
import com.ldh.portfolio.dto.project.ProjectResponseDTO;
import com.ldh.portfolio.repository.project.ProjectRepository;
import com.ldh.portfolio.validator.project.ProjectValidator;
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

    @Override
    public ProjectResponseDTO createProject(ProjectRequestDTO dto) {

        projectValidator.validateCreate(dto);

        Project project = Project.builder()
                .title(dto.getTitle())
                .summary(dto.getSummary())
                .techStack(dto.getTechStack())
                .githubUrl(dto.getGithubUrl())
                .demoUrl(dto.getDemoUrl())
                .build();

        Project saved = projectRepository.save(project);
        return responseBuilder.toDTO(saved);
    }
}
