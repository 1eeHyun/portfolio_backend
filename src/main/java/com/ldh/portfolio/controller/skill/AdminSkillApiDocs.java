package com.ldh.portfolio.controller.skill;

import com.ldh.portfolio.dto.skill.SkillRequestDTO;
import com.ldh.portfolio.dto.skill.SkillResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Admin Skill API", description = "Admin-only project API")
public interface AdminSkillApiDocs {

    @Operation(summary = "Create a new skill", description = "Create a new skill")
    ResponseEntity<SkillResponseDTO> create(@Valid @RequestBody SkillRequestDTO dto);
}
