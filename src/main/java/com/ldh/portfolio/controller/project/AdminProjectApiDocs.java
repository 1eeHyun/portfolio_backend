package com.ldh.portfolio.controller.project;

import com.ldh.portfolio.dto.project.ProjectRequestDTO;
import com.ldh.portfolio.dto.project.ProjectResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Admin Project API", description = "Admin-only project API")
public interface AdminProjectApiDocs {

    @PostMapping
    @Operation(summary = "Create a new project", description = "Create a new skill")
    ResponseEntity<ProjectResponseDTO> create(@Valid @RequestBody ProjectRequestDTO dto);
}
