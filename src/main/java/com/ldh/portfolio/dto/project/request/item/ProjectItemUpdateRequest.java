package com.ldh.portfolio.dto.project.request.item;

import com.ldh.portfolio.domain.project.ProjectOrigin;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class ProjectItemUpdateRequest {

    private Long headerId;

    private ProjectOrigin origin;

    private Long courseId;

    @Size(max = 150)
    private String title;

    @Size(max = 300)
    private String summary;

    private String description;

    private Integer year;

    @Size(max = 1024)
    private String demoUrl;

    @Size(max = 1024)
    private String githubUrl;

    private Set<@NotBlank @Size(max = 40) String> techStacks;

    private List<@Valid ProjectImageUpsertDTO> images;
}
