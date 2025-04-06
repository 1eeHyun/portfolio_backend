package com.ldh.portfolio.service.skill;

import com.ldh.portfolio.dto.skill.SkillRequestDTO;
import com.ldh.portfolio.dto.skill.SkillResponseDTO;

import java.util.List;

public interface SkillService {

    SkillResponseDTO create(SkillRequestDTO dto);
    List<SkillResponseDTO> getAll();
}
