package com.ldh.portfolio.controller.project;

import com.ldh.portfolio.dto.project.ProjectHeaderDetailDTO;
import com.ldh.portfolio.dto.project.ProjectHeaderListItemDTO;
import com.ldh.portfolio.service.project.ProjectHeaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/project-headers")
@Validated
public class ProjectHeaderController implements ProjectHeaderApiDocs {

    private final ProjectHeaderService headerService;

    @Override
    public ResponseEntity<List<ProjectHeaderListItemDTO>> list() {
        return ResponseEntity.ok(headerService.listHeaders());
    }

    @Override
    public ResponseEntity<ProjectHeaderDetailDTO> detail(@PathVariable Long headerId) {
        return ResponseEntity.ok(headerService.headerDetail(headerId));
    }
}
