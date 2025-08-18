package com.ldh.portfolio.controller.project;

import com.ldh.portfolio.dto.project.request.ProjectItemCreateRequest;
import com.ldh.portfolio.dto.project.request.ProjectItemUpdateRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AdminProjectItemApiDocs {

    @PostMapping("/project-items")
    ResponseEntity<Void> create(@Valid @RequestBody ProjectItemCreateRequest req);

    @PatchMapping("/project-items/{itemId}")
    ResponseEntity<Void> update(@PathVariable Long itemId,
                                @Valid @RequestBody ProjectItemUpdateRequest req);
}
