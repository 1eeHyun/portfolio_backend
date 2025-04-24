package com.ldh.portfolio.controller.skill;

import com.ldh.portfolio.dto.skill.SkillRequestDTO;
import com.ldh.portfolio.dto.skill.SkillResponseDTO;
import com.ldh.portfolio.service.skill.SkillService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/skills")
public class AdminSkillController implements SkillApiDocs {

    private final SkillService skillService;

    @PostMapping
    @Operation(summary = "Create a new skill", description = "Create a new skill")
    public ResponseEntity<SkillResponseDTO> create(@Valid @RequestBody  SkillRequestDTO dto) {
        return ResponseEntity.ok(skillService.create(dto));
    }
}
