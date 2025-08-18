package com.ldh.portfolio.controller.project;

import com.ldh.portfolio.dto.project.request.ProjectHeaderCreateRequest;
import com.ldh.portfolio.dto.project.request.ProjectHeaderUpdateRequest;
import com.ldh.portfolio.service.project.ProjectHeaderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/project-headers")
@Validated
@Slf4j
public class AdminProjectHeaderController implements AdminProjectHeaderApiDocs {

    private final ProjectHeaderService headerService;

    @Override
    public ResponseEntity<Void> create(@Valid @RequestBody ProjectHeaderCreateRequest req) {
        Long id = headerService.createHeader(req);

        log.info("description={}, techStacks={}, summary={}", req.getDescription(), req.getTechStacks(), req.getSubtitle());
        return ResponseEntity.created(URI.create("/api/project-headers/" + id)).build();
    }

    @Override
    public ResponseEntity<Void> update(@PathVariable Long headerId,
                                       @Valid @RequestBody ProjectHeaderUpdateRequest req) {
        headerService.updateHeader(headerId, req);
        return ResponseEntity.noContent().build();
    }
}
