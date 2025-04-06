package com.ldh.portfolio.service.skill;

import com.ldh.portfolio.builder.skill.SkillResponseBuilder;
import com.ldh.portfolio.domain.skill.Skill;
import com.ldh.portfolio.dto.skill.SkillRequestDTO;
import com.ldh.portfolio.dto.skill.SkillResponseDTO;
import com.ldh.portfolio.repository.skill.SkillRepository;
import com.ldh.portfolio.validator.skill.SkillValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;
    private final SkillValidator skillValidator;
    private final SkillResponseBuilder skillResponseBuilder;

    @Override
    public SkillResponseDTO create(SkillRequestDTO dto) {
        skillValidator.validateCreate(dto);
        Skill skill = Skill.builder()
                .name(dto.getName())
                .iconUrl(dto.getIconUrl())
                .proficiency(dto.getProficiency())
                .build();
        return skillResponseBuilder.toDTO(skillRepository.save(skill));
    }

    @Override
    public List<SkillResponseDTO> getAll() {
        return skillRepository.findAll().stream()
                .map(skillResponseBuilder::toDTO)
                .toList();
    }
}
