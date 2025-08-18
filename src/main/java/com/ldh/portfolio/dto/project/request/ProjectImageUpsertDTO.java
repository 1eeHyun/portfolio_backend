package com.ldh.portfolio.dto.project.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class ProjectImageUpsertDTO {
    private Long id;

    @NotBlank
    @Size(max = 1024)
    private String imageUrl;

    @Size(max = 255)
    private String altText;

    @NotNull
    private Integer sortOrder;

    @NotNull
    private Boolean primaryImage;

    private Integer width;
    private Integer height;
}
