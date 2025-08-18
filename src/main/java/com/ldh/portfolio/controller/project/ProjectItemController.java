package com.ldh.portfolio.controller.project;

import com.ldh.portfolio.builder.project.ProjectDtoMapper;
import com.ldh.portfolio.domain.project.ProjectItem;
import com.ldh.portfolio.dto.project.ProjectItemDetailDTO;
import com.ldh.portfolio.dto.project.ProjectItemListDTO;
import com.ldh.portfolio.service.project.ProjectItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Validated
public class ProjectItemController implements ProjectItemApiDocs {

    private final ProjectItemService itemService;
    private final ProjectDtoMapper mapper;

    @Override
    public ResponseEntity<List<ProjectItemListDTO>> listByHeader(@PathVariable Long headerId) {
        List<ProjectItem> items = itemService.listByHeader(headerId);
        return ResponseEntity.ok(items.stream().map(mapper::toItemList).toList());
    }

    @Override
    public ResponseEntity<ProjectItemDetailDTO> detail(@PathVariable Long itemId) {
        return ResponseEntity.ok(itemService.detail(itemId));
    }

}
