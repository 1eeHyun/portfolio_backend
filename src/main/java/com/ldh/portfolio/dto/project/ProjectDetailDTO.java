package com.ldh.portfolio.dto.project;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDetailDTO {
    private String featureTitle;
    private String imageUrl;
    private String techUsed;
    private String description;
}