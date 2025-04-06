package com.ldh.portfolio.controller.project;

import com.ldh.portfolio.controller.ApiBase;
import com.ldh.portfolio.dto.ProjectResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Project API", description = "Project related API")
public interface ProjectApiDocs extends ApiBase {

    @Operation(summary = "Get all projects", description = "Get every stored project")
    ResponseEntity<List<ProjectResponseDTO>> getAllProjects();

    @Operation(summary = "Get a project", description = "Get one stored project")
    ResponseEntity<ProjectResponseDTO> getProjectById(Long id);
}
