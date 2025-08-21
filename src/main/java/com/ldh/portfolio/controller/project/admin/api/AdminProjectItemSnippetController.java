package com.ldh.portfolio.controller.project.admin.api;

import com.ldh.portfolio.controller.project.admin.docs.AdminProjectItemSnippetApiDocs;
import com.ldh.portfolio.dto.project.request.snippet.ProjectItemSnippetDTO;
import com.ldh.portfolio.dto.project.request.snippet.ProjectItemSnippetUpsertReq;
import com.ldh.portfolio.dto.project.request.snippet.SnippetReorderReq;
import com.ldh.portfolio.service.project.ProjectItemSnippetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/project-items/{itemId}/snippets")
public class AdminProjectItemSnippetController implements AdminProjectItemSnippetApiDocs {

    private final ProjectItemSnippetService service;

    @GetMapping
    public ResponseEntity<List<ProjectItemSnippetDTO>> list(@PathVariable Long itemId) {
        return ResponseEntity.ok(service.listByItem(itemId));
    }

    @Override
    public ResponseEntity<ProjectItemSnippetDTO> create(
            @PathVariable Long itemId,
            @Valid @RequestBody ProjectItemSnippetUpsertReq req
    ) {

        ProjectItemSnippetDTO dto = new ProjectItemSnippetDTO(
                null,
                req.title(),
                req.language(),
                req.filePath(),
                req.code(),
                req.startLine(),
                req.endLine(),
                req.displayOrder()
        );
        return ResponseEntity.ok(service.create(itemId, dto));
    }

    @Override
    public ResponseEntity<ProjectItemSnippetDTO> updatePartial(
            @PathVariable Long itemId,
            @PathVariable Long snippetId,
            @RequestBody ProjectItemSnippetUpsertReq req
    ) {

        ProjectItemSnippetDTO dto = new ProjectItemSnippetDTO(
                snippetId,
                req.title(),
                req.language(),
                req.filePath(),
                req.code(),
                req.startLine(),
                req.endLine(),
                req.displayOrder()
        );

        return ResponseEntity.ok(service.updatePartial(itemId, snippetId, dto));
    }

    @Override
    public ResponseEntity<String> deleteOne(
            @PathVariable Long itemId,
            @PathVariable Long snippetId
    ) {

        service.delete(itemId, snippetId);
        return ResponseEntity.ok("ok");
    }

    @Override
    public ResponseEntity<String> deleteAllInItem(@PathVariable Long itemId) {

        service.deleteByItem(itemId);

        return ResponseEntity.ok("ok");
    }

    @PutMapping("/reorder")
    public ResponseEntity<List<ProjectItemSnippetDTO>> reorder(
            @PathVariable Long itemId,
            @Valid @RequestBody SnippetReorderReq req
    ) {

        List<ProjectItemSnippetDTO> orders = req.items().stream()
                .map(it -> new ProjectItemSnippetDTO(
                        it.id(), null, null, null, null, null, null, it.displayOrder()
                ))
                .toList();

        return ResponseEntity.ok(service.reorder(itemId, orders));
    }
}
