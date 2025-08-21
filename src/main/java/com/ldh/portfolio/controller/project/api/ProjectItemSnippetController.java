package com.ldh.portfolio.controller.project.api;

import com.ldh.portfolio.dto.project.request.snippet.ProjectItemSnippetDTO;
import com.ldh.portfolio.controller.project.docs.ProjectItemSnippetApiDocs;
import com.ldh.portfolio.service.project.ProjectItemSnippetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/project-items/{itemId}/snippets")
public class ProjectItemSnippetController implements ProjectItemSnippetApiDocs {

    private final ProjectItemSnippetService service;

    @Override
    public ResponseEntity<List<ProjectItemSnippetDTO>> list(Long itemId) {
        return ResponseEntity.ok(service.listByItem(itemId));
    }
}
