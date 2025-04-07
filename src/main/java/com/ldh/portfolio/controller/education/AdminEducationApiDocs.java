package com.ldh.portfolio.controller.education;

import com.ldh.portfolio.dto.education.EducationRequestDTO;
import com.ldh.portfolio.dto.education.EducationResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Admin Education API", description = "APIs for managing education records (admin only)")
@RequestMapping("/api/admin/educations")
public interface AdminEducationApiDocs {

    @PostMapping
    @Operation(
            summary = "Create an education record",
            description = "Create and save a new education record. Admin only."
    )
    ResponseEntity<EducationResponseDTO> addEducation(EducationRequestDTO dto);
}
