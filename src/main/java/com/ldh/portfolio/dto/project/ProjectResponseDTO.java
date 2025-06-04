package com.ldh.portfolio.dto.project;

import com.ldh.portfolio.dto.project.detail.ProjectDetailResponseDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectResponseDTO {

    private Long id;
    private String title;
    private String projectPicUrl;
    private String summary;
    private String techStack;
    private String githubUrl;
    private String demoUrl;
    private List<ProjectDetailResponseDTO> slides;
}

