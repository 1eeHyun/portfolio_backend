package com.ldh.portfolio.controller.project;

import com.ldh.portfolio.dto.project.ProjectHeaderDetailDTO;
import com.ldh.portfolio.dto.project.ProjectHeaderListItemDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProjectHeaderApiDocs {

    @GetMapping
    ResponseEntity<List<ProjectHeaderListItemDTO>> list();

    @GetMapping("/{headerId}")
    public ResponseEntity<ProjectHeaderDetailDTO> detail(@PathVariable Long headerId);
}
