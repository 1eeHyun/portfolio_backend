package com.ldh.portfolio.service.project;

import com.ldh.portfolio.builder.project.ProjectDtoMapper;
import com.ldh.portfolio.domain.project.DisplayMode;
import com.ldh.portfolio.domain.project.ProjectHeader;
import com.ldh.portfolio.dto.project.ProjectHeaderDetailDTO;
import com.ldh.portfolio.dto.project.ProjectHeaderListItemDTO;
import com.ldh.portfolio.dto.project.ProjectItemListDTO;
import com.ldh.portfolio.dto.project.request.header.ProjectHeaderCreateRequest;
import com.ldh.portfolio.dto.project.request.header.ProjectHeaderUpdateRequest;
import com.ldh.portfolio.repository.project.ProjectHeaderRepository;
import com.ldh.portfolio.repository.project.ProjectItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ProjectHeaderServiceImpl implements ProjectHeaderService {

    private final ProjectHeaderRepository headerRepo;
    private final ProjectItemRepository itemRepo;
    private final ProjectDtoMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<ProjectHeaderListItemDTO> listHeaders() {

        List<ProjectHeader> headers = headerRepo.findAllByOrderByYearDescSortOrderAscIdDesc();
        List<Long> ids = headers.stream().map(ProjectHeader::getId).toList();

        Map<Long, Long> countMap = itemRepo.countByHeaderIds(ids).stream()
                .collect(Collectors.toMap(
                        ProjectItemRepository.HeaderCountView::getHeaderId,
                        ProjectItemRepository.HeaderCountView::getProjectCount));

        return headers.stream()
                .map(h -> mapper.toHeaderList(h, (int) countMap.getOrDefault(h.getId(), 0L).longValue()))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjectHeaderListItemDTO> listHeaders(String q) {

        if (q == null || q.trim().isEmpty()) {
            return listHeaders();
        }

        final String query = q.trim();

        List<ProjectHeader> headers =
                headerRepo.findByTitleContainingIgnoreCaseOrderByYearDescSortOrderAscIdDesc(query);

        if (headers.isEmpty()) {
            return List.of();
        }

        List<Long> ids = headers.stream().map(ProjectHeader::getId).toList();

        Map<Long, Long> countMap = itemRepo.countByHeaderIds(ids).stream()
                .collect(Collectors.toMap(
                        ProjectItemRepository.HeaderCountView::getHeaderId,
                        ProjectItemRepository.HeaderCountView::getProjectCount
                ));

        return headers.stream()
                .map(h -> mapper.toHeaderList(
                        h,
                        Math.toIntExact(countMap.getOrDefault(h.getId(), 0L))
                ))
                .toList();
    }


    @Override
    @Transactional(readOnly = true)
    public ProjectHeaderDetailDTO headerDetail(Long headerId) {

        ProjectHeader header = headerRepo.findById(headerId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
        List<ProjectItemListDTO> items = itemRepo.findByHeader_IdOrderByYearDescIdDesc(headerId)
                .stream().map(mapper::toItemList).toList();
        return mapper.toHeaderDetail(header, items);
    }


    @Override
    @Transactional
    public Long createHeader(ProjectHeaderCreateRequest req) {
        validateHeaderLinks(req.getDisplayMode(), req.getLiveUrl(), req.getGithubUrl(), req.getDocsUrl(), req.getVideoUrl());

        ProjectHeader header = ProjectHeader.builder()
                .title(req.getTitle())
                .subtitle(req.getSubtitle())
                .coverImageUrl(req.getCoverImageUrl())
                .year(req.getYear())
                .sortOrder(req.getSortOrder())
                .description(req.getDescription())
                .displayMode(req.getDisplayMode())
                .liveUrl(req.getLiveUrl())
                .githubUrl(req.getGithubUrl())
                .docsUrl(req.getDocsUrl())
                .videoUrl(req.getVideoUrl())
                .techStacks(normalizeStacks(req.getTechStacks()))
                .build();

        return headerRepo.save(header).getId();
    }

    @Override
    @Transactional
    public void updateHeader(Long headerId, ProjectHeaderUpdateRequest req) {

        ProjectHeader h = headerRepo.findById(headerId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        if (req.getTitle() != null) h.setTitle(req.getTitle());
        if (req.getSubtitle() != null) h.setSubtitle(req.getSubtitle());
        if (req.getCoverImageUrl() != null) h.setCoverImageUrl(req.getCoverImageUrl());
        if (req.getYear() != null) h.setYear(req.getYear());
        if (req.getSortOrder() != null) h.setSortOrder(req.getSortOrder());
        if (req.getDescription() != null) h.setDescription(req.getDescription());

        if (req.getDisplayMode() != null) h.setDisplayMode(req.getDisplayMode());
        if (req.getLiveUrl() != null) h.setLiveUrl(req.getLiveUrl());
        if (req.getGithubUrl() != null) h.setGithubUrl(req.getGithubUrl());
        if (req.getDocsUrl() != null) h.setDocsUrl(req.getDocsUrl());
        if (req.getVideoUrl() != null) h.setVideoUrl(req.getVideoUrl());

        validateHeaderLinks(h.getDisplayMode(), h.getLiveUrl(), h.getGithubUrl(), h.getDocsUrl(), h.getVideoUrl());

        if (req.getTechStacks() != null) {
            h.setTechStacks(normalizeStacks(req.getTechStacks()));
        }
    }

    private void validateHeaderLinks(DisplayMode mode, String live, String gh, String docs, String vid) {

        if (mode == null) return;
        switch (mode) {
            case LIVE -> {
                if (isBlank(live)) throw new ResponseStatusException(BAD_REQUEST, "LIVE requires liveUrl");
            }
            case INTERNAL -> { /* no-op */ }
        }
    }

    private boolean isBlank(String s) {
        return s == null || s.isBlank();
    }

    private Set<String> normalizeStacks(Set<String> input) {
        if (input == null) return new LinkedHashSet<>();
        return input.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
