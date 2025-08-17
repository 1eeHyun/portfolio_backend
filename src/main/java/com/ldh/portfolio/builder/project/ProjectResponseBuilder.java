package com.ldh.portfolio.builder.project;

import com.ldh.portfolio.domain.project.Project;
import com.ldh.portfolio.domain.project.ProjectDetail;
import com.ldh.portfolio.dto.project.ProjectResponseDTO;
import com.ldh.portfolio.dto.project.detail.ProjectDetailResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectResponseBuilder {

    public ProjectResponseDTO toDTO(Project project) {
        return ProjectResponseDTO.builder()
                .id(project.getId())
                .year(project.getYear())
                .projectPicUrl(project.getProjectPicUrl())
                .title(project.getTitle())
                .summary(project.getSummary())
                .techStack(project.getTechStack())
                .githubUrl(project.getGithubUrl())
                .demoUrl(project.getDemoUrl())
                .slides(toSlideDTOs(project.getDetails()))
                .build();
    }

    private List<ProjectDetailResponseDTO> toSlideDTOs(List<ProjectDetail> details) {
        return details.stream().map(detail ->
                ProjectDetailResponseDTO.builder()
                        .featureTitle(detail.getFeatureTitle())
                        .imageUrl(detail.getImageUrl())
                        .techUsed(detail.getTechUsed())
                        .description(detail.getDescription())
                        .demoLink(detail.getDemoLink())
                        .build()
        ).collect(Collectors.toList());
    }
}
