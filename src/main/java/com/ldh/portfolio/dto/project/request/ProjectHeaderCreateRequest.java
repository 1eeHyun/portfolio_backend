package com.ldh.portfolio.dto.project.request;

import com.ldh.portfolio.domain.project.DisplayMode;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class ProjectHeaderCreateRequest {

    @NotBlank
    @Size(max = 120)
    private String title;

    @Size(max = 300)
    private String subtitle;

    @Size(max = 1024)
    private String coverImageUrl;

    private Integer year;

    private Integer sortOrder;

    private String description;

    @NotNull
    private DisplayMode displayMode;

    @Size(max = 1024)
    private String liveUrl;

    @Size(max = 1024)
    private String githubUrl;

    @Size(max = 1024)
    private String docsUrl;

    @Size(max = 1024)
    private String videoUrl;

    /** Header-level tech stacks */
    @Builder.Default
    private Set<@NotBlank @Size(max = 40) String> techStacks = new LinkedHashSet<>();
}
