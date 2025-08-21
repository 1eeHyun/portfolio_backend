package com.ldh.portfolio.dto.project.request.snippet;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record SnippetReorderReq(
        @NotEmpty List<SnippetOrderItem> items
) {
    public record SnippetOrderItem(
            @NotNull Long id,
            @NotNull Integer displayOrder
    ) {}
}
