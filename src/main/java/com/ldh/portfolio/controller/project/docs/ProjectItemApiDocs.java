package com.ldh.portfolio.controller.project.docs;

import com.ldh.portfolio.dto.project.ProjectItemDetailDTO;
import com.ldh.portfolio.dto.project.ProjectItemListDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProjectItemApiDocs {

    @GetMapping("/project-headers/{headerId}/items")
    ResponseEntity<List<ProjectItemListDTO>> listByHeader(@PathVariable Long headerId);

    @GetMapping("/project-items/{itemId}")
    ResponseEntity<ProjectItemDetailDTO> detail(@PathVariable Long itemId);
}
