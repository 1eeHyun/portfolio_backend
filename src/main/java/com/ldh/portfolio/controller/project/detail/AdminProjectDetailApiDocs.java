package com.ldh.portfolio.controller.project.detail;

import com.ldh.portfolio.dto.project.detail.ProjectDetailRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Admin Project Detail API", description = "Add a slide to a certain project (Only admin) API")
public interface AdminProjectDetailApiDocs {

    @Operation(summary = "Add slide to project", description = "Add description to a certain project.")
    ResponseEntity<Void> addDetail(Long projectId, ProjectDetailRequestDTO dto);
}
