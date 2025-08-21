package com.ldh.portfolio.dto.project.request.snippet;

import jakarta.validation.constraints.NotBlank;

public record ProjectItemSnippetUpsertReq(
        @NotBlank String title,
        @NotBlank String language,
        String filePath,
        @NotBlank String code,
        Integer startLine,
        Integer endLine,
        Integer displayOrder
) {
}
