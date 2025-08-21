package com.ldh.portfolio.controller.project.docs;

import com.ldh.portfolio.dto.project.ProjectHeaderDetailDTO;
import com.ldh.portfolio.dto.project.ProjectHeaderListItemDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProjectHeaderApiDocs {

    @GetMapping
    ResponseEntity<List<ProjectHeaderListItemDTO>> list(
            @RequestParam(value = "q", required = false) String q
    );

    @GetMapping("/{headerId}")
    ResponseEntity<ProjectHeaderDetailDTO> detail(@PathVariable Long headerId);
}
