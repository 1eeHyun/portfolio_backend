package com.ldh.portfolio.controller.course;

import com.ldh.portfolio.dto.course.CourseResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Course API", description = "Public API to fetch about section")
public interface CourseApiDocs {

    @Operation(summary = "Get course", description = "Retrieve the about section information")
    ResponseEntity<CourseResponseDTO> getCourse();
}
