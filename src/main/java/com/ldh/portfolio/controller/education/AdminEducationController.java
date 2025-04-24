package com.ldh.portfolio.controller.education;

import com.ldh.portfolio.dto.education.EducationRequestDTO;
import com.ldh.portfolio.dto.education.EducationResponseDTO;
import com.ldh.portfolio.service.education.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/educations")
public class AdminEducationController implements AdminEducationApiDocs {

    private final EducationService educationService;

    @Override
    public ResponseEntity<EducationResponseDTO> addEducation(@RequestBody EducationRequestDTO dto) {
        return ResponseEntity.ok(educationService.create(dto));
    }
}
