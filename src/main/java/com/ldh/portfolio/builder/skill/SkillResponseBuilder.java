package com.ldh.portfolio.builder.skill;

import com.ldh.portfolio.domain.skill.Skill;
import com.ldh.portfolio.dto.skill.SkillResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class SkillResponseBuilder {

    public SkillResponseDTO toDTO(Skill skill) {
        return SkillResponseDTO.builder()
                .id(skill.getId())
                .name(skill.getName())
                .iconUrl(skill.getIconUrl())
                .proficiency(skill.getProficiency())
                .build();
    }
}
