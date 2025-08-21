package com.ldh.portfolio.controller.project.admin.docs;

import com.ldh.portfolio.dto.project.request.header.ProjectHeaderCreateRequest;
import com.ldh.portfolio.dto.project.request.header.ProjectHeaderUpdateRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AdminProjectHeaderApiDocs {

    @PostMapping
    ResponseEntity<Void> create(@Valid @RequestBody ProjectHeaderCreateRequest req);

    @PatchMapping("/{headerId}")
    ResponseEntity<Void> update(@PathVariable Long headerId,
                                @Valid @RequestBody ProjectHeaderUpdateRequest req);
}
