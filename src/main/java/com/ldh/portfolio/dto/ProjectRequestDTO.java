package com.ldh.portfolio.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectRequestDTO {

    @NotBlank
    private String title;

    private String description;
}
