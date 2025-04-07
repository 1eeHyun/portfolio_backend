package com.ldh.portfolio.controller.education;

import com.ldh.portfolio.controller.ApiBase;
import com.ldh.portfolio.dto.education.EducationResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;


@Tag(name = "Education API", description = "Public API for viewing education records")
public interface EducationApiDocs extends ApiBase {

    @Operation(
            summary = "Get all education records",
            description = "Retrieve a list of all stored education records for public display."
    )
    ResponseEntity<List<EducationResponseDTO>> getAllEducations();
}
