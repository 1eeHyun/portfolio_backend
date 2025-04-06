package com.ldh.portfolio.dto.skill;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillResponseDTO {

    private Long id;
    private String name;
    private String iconUrl;
    private int proficiency;
}
