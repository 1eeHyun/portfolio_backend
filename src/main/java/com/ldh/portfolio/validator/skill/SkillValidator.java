package com.ldh.portfolio.validator.skill;

import com.ldh.portfolio.dto.skill.SkillRequestDTO;
import com.ldh.portfolio.repository.skill.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SkillValidator {

    private final SkillRepository skillRepository;

    public void validateCreate(SkillRequestDTO dto) {
        if (skillRepository.existsByName(dto.getName())) {
            throw new IllegalArgumentException("The skill already exists.");
        }
    }
}
