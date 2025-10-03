package com.ldh.portfolio.controller.project.admin.api;

import com.ldh.portfolio.controller.project.admin.docs.AdminProjectItemApiDocs;
import com.ldh.portfolio.dto.project.request.item.ProjectItemCreateRequest;
import com.ldh.portfolio.dto.project.request.item.ProjectItemUpdateRequest;
import com.ldh.portfolio.service.project.ProjectItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
@Validated
public class AdminProjectItemController implements AdminProjectItemApiDocs {

    private final ProjectItemService itemService;

    @Override
    public ResponseEntity<Void> create(@Valid @RequestBody ProjectItemCreateRequest req) {
        Long id = itemService.create(req);
        return ResponseEntity.created(URI.create("/api/project-items/" + id)).build();
    }


    @Override
    public ResponseEntity<Void> update(@PathVariable Long itemId,
                                       @Valid @RequestBody ProjectItemUpdateRequest req) {
        itemService.update(itemId, req);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> delete(@PathVariable Long itemId) {
        itemService.delete(itemId);
        return ResponseEntity.noContent().build();
    }
}
