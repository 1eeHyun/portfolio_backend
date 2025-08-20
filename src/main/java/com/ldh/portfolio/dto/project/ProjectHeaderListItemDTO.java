package com.ldh.portfolio.dto.project;

import com.ldh.portfolio.domain.project.DisplayMode;
import lombok.*;

import java.util.Set;

@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectHeaderListItemDTO {
    private Long id;
    private String title;
    private String subtitle;
    private String coverImageUrl;
    private Integer year;
    private Integer projectCount;

    private DisplayMode displayMode;  // INTERNAL/LIVE/GITHUB/DOCS/VIDEO
    private String externalUrl;
    private boolean hasExternalLink;

    private String githubUrl;

    private Set<String> techStacks;
}
