package com.ldh.portfolio.dto.project;

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
    private String summary;
    private String techStack;
    private String githubUrl;
    private String demoUrl;
    private List<ProjectDetailDTO> slides;
}

