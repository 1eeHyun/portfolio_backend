package com.ldh.portfolio.dto.project.request;

import com.ldh.portfolio.domain.project.DisplayMode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class ProjectHeaderUpdateRequest {

    @Size(max = 120)
    private String title;

    @Size(max = 300)
    private String subtitle;

    @Size(max = 1024)
    private String coverImageUrl;

    private Integer year;

    private Integer sortOrder;

    private String description;

    private DisplayMode displayMode;

    @Size(max = 1024)
    private String liveUrl;

    @Size(max = 1024)
    private String githubUrl;

    @Size(max = 1024)
    private String docsUrl;

    @Size(max = 1024)
    private String videoUrl;

    private Set<@NotBlank @Size(max = 40) String> techStacks;
}
