package com.ldh.portfolio.builder.project;

import com.ldh.portfolio.domain.project.ProjectHeader;
import com.ldh.portfolio.domain.project.ProjectImage;
import com.ldh.portfolio.domain.project.ProjectItem;
import com.ldh.portfolio.domain.project.ProjectOrigin;
import com.ldh.portfolio.dto.project.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectDtoMapper {

    /** ========== IMAGE ========== */
    public ImageDTO toImageDTO(ProjectImage img) {
        if (img == null) return null;
        return ImageDTO.builder()
                .url(img.getImageUrl())
                .alt(img.getAltText())
                .order(img.getSortOrder())
                .primary(img.isPrimaryImage())
                .width(img.getWidth())
                .height(img.getHeight())
                .build();
    }

    /** ========== HEADER ========== */
    public ProjectHeaderListItemDTO toHeaderList(ProjectHeader h, int projectCount) {
        String external = null;
        if (h.getDisplayMode() != null) {
            switch (h.getDisplayMode()) {
                case LIVE -> external = h.getLiveUrl();
                case GITHUB -> external = h.getGithubUrl();
                case DOCS -> external = h.getDocsUrl();
                case VIDEO -> external = h.getVideoUrl();
                default -> external = null;
            }
        }

        return ProjectHeaderListItemDTO.builder()
                .id(h.getId())
                .title(h.getTitle())
                .subtitle(h.getSubtitle())
                .coverImageUrl(h.getCoverImageUrl())
                .year(h.getYear())
                .projectCount(projectCount)
                .displayMode(h.getDisplayMode())
                .externalUrl(external)
                .githubUrl(h.getGithubUrl())
                .hasExternalLink(external != null && !external.isBlank())
                .techStacks(h.getTechStacks())
                .build();
    }

    public ProjectHeaderDetailDTO toHeaderDetail(ProjectHeader h, List<ProjectItemListDTO> items) {
        return ProjectHeaderDetailDTO.builder()
                .id(h.getId())
                .title(h.getTitle())
                .subtitle(h.getSubtitle())
                .coverImageUrl(h.getCoverImageUrl())
                .year(h.getYear())
                .description(h.getDescription())
                .techStacks(h.getTechStacks())
                .projects(items)
                .build();
    }

    /** ========== ITEM ========== */
    public ProjectItemListDTO toItemList(ProjectItem p) {
        boolean hasDemo = p.getOrigin() == ProjectOrigin.PERSONAL
                && p.getDemoUrl() != null && !p.getDemoUrl().isBlank();

        return ProjectItemListDTO.builder()
                .id(p.getId())
                .title(p.getTitle())
                .summary(p.getSummary())
                .year(p.getYear())
                .description(p.getDescription())
                .techStacks(p.getTechStacks())
                .images(p.getImages().stream().map(this::toImageDTO).toList())
                .hasDemo(hasDemo)
                .demoUrl(hasDemo ? p.getDemoUrl() : null)
                .build();
    }

    public ProjectItemDetailDTO toItemDetail(ProjectItem p) {
        return ProjectItemDetailDTO.builder()
                .id(p.getId())
                .title(p.getTitle())
                .description(p.getDescription())
                .year(p.getYear())
                .techStacks(p.getTechStacks())
                .images(p.getImages().stream().map(this::toImageDTO).collect(Collectors.toList()))
                .githubUrl(p.getGithubUrl())
                .demoUrl(p.getOrigin() == ProjectOrigin.PERSONAL ? p.getDemoUrl() : null)
                .course(p.getOrigin() == ProjectOrigin.COURSE && p.getCourse() != null
                        ? CourseRefDTO.builder()
                        .id(p.getCourse().getId())
                        .code(p.getCourse().getCode())
                        .name(p.getCourse().getName())
                        .year(p.getCourse().getYear())
                        .logoUrl(p.getCourse().getLogoUrl())
                        .build()
                        : null)
                .build();
    }
}

