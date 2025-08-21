package com.ldh.portfolio.controller.project.docs;

import com.ldh.portfolio.dto.project.request.snippet.ProjectItemSnippetDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "Project Snippet API", description = "Project Snippet API for viewing project's code")
public interface ProjectItemSnippetApiDocs {

    @GetMapping
    @Operation(
            summary = "Retrieve list of a project's code",
            description = "Retrieve list of a project's code."
    )
    ResponseEntity<List<ProjectItemSnippetDTO>> list(@PathVariable Long itemId);
}
