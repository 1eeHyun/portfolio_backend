package com.ldh.portfolio.controller.skill;

import com.ldh.portfolio.dto.skill.SkillRequestDTO;
import com.ldh.portfolio.dto.skill.SkillResponseDTO;
import com.ldh.portfolio.service.skill.SkillService;
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
public class AdminSkillController implements AdminSkillApiDocs {

    private final SkillService skillService;

    @Override
    @PostMapping
    public ResponseEntity<SkillResponseDTO> create(@Valid @RequestBody  SkillRequestDTO dto) {
        return ResponseEntity.ok(skillService.create(dto));
    }
}
