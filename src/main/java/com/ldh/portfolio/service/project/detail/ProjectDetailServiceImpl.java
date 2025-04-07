package com.ldh.portfolio.service.project.detail;

import com.ldh.portfolio.domain.project.Project;
import com.ldh.portfolio.domain.project.ProjectDetail;
import com.ldh.portfolio.dto.project.detail.ProjectDetailRequestDTO;
import com.ldh.portfolio.dto.project.detail.ProjectDetailResponseDTO;
import com.ldh.portfolio.repository.project.ProjectDetailRepository;
import com.ldh.portfolio.repository.project.ProjectRepository;
import com.ldh.portfolio.validator.project.ProjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectDetailServiceImpl implements ProjectDetailService{

    private final ProjectRepository projectRepository;
    private final ProjectDetailRepository detailRepository;
    private final ProjectValidator projectValidator;

    @Override
    public void addDetail(ProjectDetailRequestDTO dto) {

        Project project = projectValidator.validateExists(dto.getProjectId());

        ProjectDetail detail = ProjectDetail.builder()
                .featureTitle(dto.getFeatureTitle())
                .imageUrl(dto.getImageUrl())
                .techUsed(dto.getTechUsed())
                .description(dto.getDescription())
                .project(project)
                .build();

        detailRepository.save(detail);
    }

    @Override
    public List<ProjectDetailResponseDTO> getDetailsByProjectId(Long projectId) {

        return detailRepository.findByProjectId(projectId).stream()
                .map(detail -> ProjectDetailResponseDTO.builder()
                        .featureTitle(detail.getFeatureTitle())
                        .imageUrl(detail.getImageUrl())
                        .techUsed(detail.getTechUsed())
                        .description(detail.getDescription())
                        .build())
                .toList();
    }
}
