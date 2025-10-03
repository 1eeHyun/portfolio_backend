package com.ldh.portfolio.controller.project.admin.docs;

import com.ldh.portfolio.dto.project.request.header.ProjectHeaderCreateRequest;
import com.ldh.portfolio.dto.project.request.header.ProjectHeaderUpdateRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface AdminProjectHeaderApiDocs {

    @PostMapping
    ResponseEntity<Void> create(@Valid @RequestBody ProjectHeaderCreateRequest req);

    @PatchMapping("/{headerId}")
    ResponseEntity<Void> update(@PathVariable Long headerId,
                                @Valid @RequestBody ProjectHeaderUpdateRequest req);

    @DeleteMapping("/{headerId}")
    ResponseEntity<Void> delete(@PathVariable Long headerId);
}
