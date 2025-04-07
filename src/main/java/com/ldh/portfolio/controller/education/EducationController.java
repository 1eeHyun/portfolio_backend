package com.ldh.portfolio.controller.education;

import com.ldh.portfolio.dto.education.EducationResponseDTO;
import com.ldh.portfolio.service.education.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/educations")
public class EducationController implements EducationApiDocs {

    private final EducationService educationService;

    @Override
    @GetMapping
    public ResponseEntity<List<EducationResponseDTO>> getAllEducations() {
        return ResponseEntity.ok(educationService.getAll());
    }
}
