package com.ldh.portfolio.controller.project;

import com.ldh.portfolio.dto.project.ProjectResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "Project API", description = "Project related API")
@RequestMapping("/api/projects")
public interface ProjectApiDocs {

    @Operation(summary = "Get all projects", description = "Get every stored project")
    public ResponseEntity<List<ProjectResponseDTO>> getAllProjects();

    @Operation(summary = "Get a project", description = "Get one stored project")
    public ResponseEntity<ProjectResponseDTO> getProjectById(@PathVariable Long id);
}
