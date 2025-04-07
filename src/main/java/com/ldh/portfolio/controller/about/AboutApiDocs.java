package com.ldh.portfolio.controller.about;

import com.ldh.portfolio.controller.ApiBase;
import com.ldh.portfolio.dto.about.AboutResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "About API", description = "Public API to fetch about section")
public interface AboutApiDocs extends ApiBase {

    @Operation(summary = "Get about", description = "Retrieve the about section information")
    public ResponseEntity<AboutResponseDTO> getAbout();
}
