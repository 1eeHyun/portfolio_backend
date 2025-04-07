package com.ldh.portfolio.controller.project.detail;

import com.ldh.portfolio.dto.project.detail.ProjectDetailResponseDTO;
import com.ldh.portfolio.service.project.detail.ProjectDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProjectDetailController {

    private final ProjectDetailService detailService;

    @GetMapping
    public ResponseEntity<List<ProjectDetailResponseDTO>> getDetails(@PathVariable Long projectId) {
        return ResponseEntity.ok(detailService.getDetailsByProjectId(projectId));
    }
}
