package com.ldh.portfolio.dto.project.detail;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDetailResponseDTO {

    private String featureTitle;
    private String imageUrl;
    private String techUsed;
    private String description;
}
