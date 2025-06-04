package com.ldh.portfolio.controller.skill;

import com.ldh.portfolio.dto.skill.SkillResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Skill API", description = "Skill related API")
public interface SkillApiDocs {

    @Operation(summary = "Get all skills", description = "Returns all skills")
    ResponseEntity<List<SkillResponseDTO>> getAllSkills();
}
