package com.ldh.portfolio.dto.project.request.item;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectItemImagesReplaceRequest {

    @NotNull
    private Long projectItemId;

    @NotNull
    private List<@Valid ProjectImageUpsertDTO> images;
}
