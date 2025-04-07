package com.ldh.portfolio.dto.project;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectRequestDTO {

    @NotBlank
    private String title;

    private String summary;
    private String techStack;
    private String githubUrl;
    private String demoUrl;
}
