package com.ldh.portfolio.dto.project.request.snippet;

import com.ldh.portfolio.domain.project.ProjectItemSnippet;

public record ProjectItemSnippetDTO(
        Long id,
        String title,
        String language,
        String filePath,
        String code,
        Integer startLine,
        Integer endLine,
        Integer displayOrder
) {

    public static ProjectItemSnippetDTO from(ProjectItemSnippet s) {
        return new ProjectItemSnippetDTO(
                s.getId(), s.getTitle(), s.getLanguage(), s.getFilePath(),
                s.getCode(), s.getStartLine(), s.getEndLine(), s.getDisplayOrder()
        );
    }
}
