package com.ldh.portfolio.controller.about;

import com.ldh.portfolio.dto.about.AboutResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "About API", description = "Public API to fetch about section")
@RequestMapping("/api/about")
public interface AboutApiDocs{

    @Operation(summary = "Get about", description = "Retrieve the about section information")
    ResponseEntity<AboutResponseDTO> getAbout();
}
