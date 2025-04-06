package com.ldh.portfolio.controller.skill;

import com.ldh.portfolio.dto.skill.SkillResponseDTO;
import com.ldh.portfolio.service.skill.SkillService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/skills")
public class SkillController implements SkillApiDocs {

    private final SkillService skillService;

    @GetMapping
    @Operation(summary = "Get all skills", description = "Returns all skills")
    public ResponseEntity<List<SkillResponseDTO>> getAllSkills() {
        return ResponseEntity.ok(skillService.getAll());
    }
}
