package com.ldh.portfolio.controller.project.detail;

import com.ldh.portfolio.dto.project.detail.ProjectDetailResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Project Detail API", description = "Public project detail API")
public interface ProjectDetailApiDocs{

    @Operation(summary = "Get slides of project", description = "Retrieves a certain project's slides(Functional description).")
    ResponseEntity<List<ProjectDetailResponseDTO>> getDetails(Long projectId);
}
