package com.ldh.portfolio.dto.project;


import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectItemDetailDTO {

    private Long id;
    private String title;
    private String description;
    private Integer year;

    private Set<String> techStacks;
    private List<ImageDTO> images;

    private String githubUrl;   // optional
    private String demoUrl;     // PERSONAL

    private CourseRefDTO course; // COURSE일
}
