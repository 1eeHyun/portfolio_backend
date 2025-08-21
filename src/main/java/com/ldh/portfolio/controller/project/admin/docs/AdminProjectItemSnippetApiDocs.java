package com.ldh.portfolio.controller.project.admin.docs;

import com.ldh.portfolio.dto.project.request.snippet.ProjectItemSnippetDTO;
import com.ldh.portfolio.dto.project.request.snippet.ProjectItemSnippetUpsertReq;
import com.ldh.portfolio.dto.project.request.snippet.SnippetReorderReq;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AdminProjectItemSnippetApiDocs {

    @GetMapping
    ResponseEntity<List<ProjectItemSnippetDTO>> list(@PathVariable Long itemId);

    @PostMapping
    ResponseEntity<ProjectItemSnippetDTO> create(
            @PathVariable Long itemId,
            @Valid @RequestBody ProjectItemSnippetUpsertReq req
    );

    @PatchMapping("/{snippetId}")
    ResponseEntity<ProjectItemSnippetDTO> updatePartial(
            @PathVariable Long itemId,
            @PathVariable Long snippetId,
            @RequestBody ProjectItemSnippetUpsertReq req
    );

    @DeleteMapping("/{snippetId}")
    ResponseEntity<String> deleteOne(
            @PathVariable Long itemId,
            @PathVariable Long snippetId
    );

    @DeleteMapping
    ResponseEntity<String> deleteAllInItem(@PathVariable Long itemId);

    @PutMapping("/reorder")
    ResponseEntity<List<ProjectItemSnippetDTO>> reorder(
            @PathVariable Long itemId,
            @Valid @RequestBody SnippetReorderReq req
    );
}
