package com.ldh.portfolio.dto.project.request;

import com.ldh.portfolio.domain.project.ProjectOrigin;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class ProjectItemCreateRequest {

    @NotNull
    private Long headerId;

    /** PERSONAL or COURSE */
    @NotNull
    private ProjectOrigin origin;

    private Long courseId;

    @NotBlank
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

    /** Item-level tech stacks */
    @Builder.Default
    private Set<@NotBlank @Size(max = 40) String> techStacks = new LinkedHashSet<>();

    @Builder.Default
    private List<@Valid ProjectImageUpsertDTO> images = List.of();
}
