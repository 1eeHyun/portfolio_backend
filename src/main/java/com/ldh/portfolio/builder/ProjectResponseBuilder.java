package com.ldh.portfolio.builder;

import com.ldh.portfolio.domain.project.Project;
import com.ldh.portfolio.domain.project.ProjectDetail;
import com.ldh.portfolio.dto.ProjectDetailDTO;
import com.ldh.portfolio.dto.ProjectResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectResponseBuilder {

    public ProjectResponseDTO toDTO(Project project) {
        return ProjectResponseDTO.builder()
                .id(project.getId())
                .title(project.getTitle())
                .summary(project.getSummary())
                .techStack(project.getTechStack())
                .githubUrl(project.getGithubUrl())
                .demoUrl(project.getDemoUrl())
                .slides(toSlideDTOs(project.getSlides()))
                .build();
    }

    private List<ProjectDetailDTO> toSlideDTOs(List<ProjectDetail> details) {
        return details.stream().map(detail ->
                ProjectDetailDTO.builder()
                        .featureTitle(detail.getFeatureTitle())
                        .imageUrl(detail.getImageUrl())
                        .techUsed(detail.getTechUsed())
                        .description(detail.getDescription())
                        .build()
        ).collect(Collectors.toList());
    }
}
