package com.ldh.portfolio.controller.about;

import com.ldh.portfolio.dto.about.AboutRequestDTO;
import com.ldh.portfolio.dto.about.AboutResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Admin About API", description = "Admin-only API to create or update about section")
public interface AdminAboutApiDocs {

    @Operation(summary = "Create or update about", description = "Create or update the about section content")
    ResponseEntity<AboutResponseDTO> createOrUpdate(AboutRequestDTO dto);
}
