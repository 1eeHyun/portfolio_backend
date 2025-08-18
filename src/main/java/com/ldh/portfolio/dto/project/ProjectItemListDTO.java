package com.ldh.portfolio.dto.project;

import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectItemListDTO {
    private Long id;
    private String title;
    private String summary;
    private Integer year;

    private List<ImageDTO> images;
    private String description;
    private Set<String> techStacks;

    private boolean hasDemo;
    private String demoUrl;
}
