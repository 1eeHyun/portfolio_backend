package com.ldh.portfolio.service.project;

import com.ldh.portfolio.dto.project.request.snippet.ProjectItemSnippetDTO;
import com.ldh.portfolio.domain.project.ProjectItem;
import com.ldh.portfolio.domain.project.ProjectItemSnippet;
import com.ldh.portfolio.repository.project.ProjectItemRepository;
import com.ldh.portfolio.repository.project.ProjectItemSnippetRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProjectItemSnippetServiceImpl implements ProjectItemSnippetService {

    private final ProjectItemSnippetRepository snippetRepo;
    private final ProjectItemRepository itemRepo;

    @Override
    public List<ProjectItemSnippetDTO> listByItem(Long itemId) {

        return snippetRepo.findByProjectItemIdOrderByDisplayOrderAsc(itemId)
                .stream()
                .map(ProjectItemSnippetDTO::from)
                .toList();
    }

    @Override
    @Transactional
    public ProjectItemSnippetDTO create(Long itemId, ProjectItemSnippetDTO req) {

        ProjectItem item = itemRepo.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("ProjectItem not found: " + itemId));

        ProjectItemSnippet s = new ProjectItemSnippet();
        s.setProjectItem(item);
        s.setTitle(safe(req.title()));
        s.setLanguage(safe(req.language()));
        s.setFilePath(req.filePath());
        s.setCode(req.code());
        s.setStartLine(req.startLine());
        s.setEndLine(req.endLine());
        s.setDisplayOrder(req.displayOrder() == null ? 0 : req.displayOrder());

        return ProjectItemSnippetDTO.from(snippetRepo.save(s));
    }

    @Override
    @Transactional
    public ProjectItemSnippetDTO updatePartial(Long itemId, Long snippetId, ProjectItemSnippetDTO req) {

        ProjectItemSnippet s = snippetRepo.findById(snippetId)
                .orElseThrow(() -> new EntityNotFoundException("Snippet not found: " + snippetId));
        if (!s.getProjectItem().getId().equals(itemId)) {
            throw new IllegalArgumentException("Snippet " + snippetId + " does not belong to item " + itemId);
        }

        if (req.title() != null) s.setTitle(safe(req.title()));
        if (req.language() != null) s.setLanguage(safe(req.language()));
        if (req.filePath() != null) s.setFilePath(req.filePath());
        if (req.code() != null) s.setCode(req.code());
        if (req.startLine() != null) s.setStartLine(req.startLine());
        if (req.endLine() != null) s.setEndLine(req.endLine());
        if (req.displayOrder() != null) s.setDisplayOrder(req.displayOrder());

        return ProjectItemSnippetDTO.from(s);
    }

    @Override
    @Transactional
    public void delete(Long itemId, Long snippetId) {
        ProjectItemSnippet s = snippetRepo.findById(snippetId)
                .orElseThrow(() -> new EntityNotFoundException("Snippet not found: " + snippetId));
        if (!s.getProjectItem().getId().equals(itemId)) {
            throw new IllegalArgumentException("Snippet " + snippetId + " does not belong to item " + itemId);
        }
        snippetRepo.delete(s);
    }

    @Override
    @Transactional
    public void deleteByItem(Long itemId) {
        snippetRepo.deleteByProjectItemId(itemId);
    }

    @Override
    @Transactional
    public List<ProjectItemSnippetDTO> reorder(Long itemId, List<ProjectItemSnippetDTO> orders) {

        for (ProjectItemSnippetDTO dto : orders) {
            if (dto.id() == null) {
                throw new IllegalArgumentException("id is required in reorder");
            }
            if (dto.displayOrder() == null) {
                throw new IllegalArgumentException("displayOrder is required for snippet " + dto.id());
            }

            ProjectItemSnippet s = snippetRepo.findById(dto.id())
                    .orElseThrow(() -> new EntityNotFoundException("Snippet not found: " + dto.id()));

            if (!s.getProjectItem().getId().equals(itemId)) {
                throw new IllegalArgumentException("Snippet " + dto.id() + " does not belong to item " + itemId);
            }

            s.setDisplayOrder(dto.displayOrder());
        }
        return listByItem(itemId);
    }

    private String safe(String s) { return s == null ? null : s.trim(); }
}
