package com.ldh.portfolio.controller.project;


import com.ldh.portfolio.dto.project.ProjectRequestDTO;
import com.ldh.portfolio.dto.project.ProjectResponseDTO;
import com.ldh.portfolio.service.project.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/projects")
@RequiredArgsConstructor
public class AdminProjectController implements AdminProjectApiDocs {

    private final ProjectService projectService;

    @Override
    @PostMapping
    public ResponseEntity<ProjectResponseDTO> create(@Valid @RequestBody ProjectRequestDTO dto) {
        return ResponseEntity.ok(projectService.createProject(dto));
    }
}
