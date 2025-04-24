package com.ldh.portfolio.controller.project.detail;

import com.ldh.portfolio.dto.project.detail.ProjectDetailRequestDTO;
import com.ldh.portfolio.service.project.detail.ProjectDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/projects/{postId}/details")
public class AdminProjectDetailController implements AdminProjectDetailApiDocs{

    private final ProjectDetailService detailService;

    @PostMapping
    public ResponseEntity<Void> addDetail(@PathVariable Long projectId,
                                          @RequestBody ProjectDetailRequestDTO dto) {
        dto.setProjectId(projectId);
        detailService.addDetail(dto);
        return ResponseEntity.ok().build();
    }
}
