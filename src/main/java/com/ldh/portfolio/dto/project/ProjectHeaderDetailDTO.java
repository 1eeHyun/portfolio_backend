package com.ldh.portfolio.dto.project;

import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectHeaderDetailDTO {
    private Long id;
    private String title;
    private String subtitle;
    private String coverImageUrl;
    private Integer year;
    private String description;

    private Set<String> techStacks;         // Header
    private List<ProjectItemListDTO> projects;
}
