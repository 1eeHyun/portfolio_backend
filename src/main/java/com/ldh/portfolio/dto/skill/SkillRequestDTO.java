package com.ldh.portfolio.dto.skill;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillRequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String iconUrl;

    @Min(0)
    @Max(100)
    private int proficiency;
}
