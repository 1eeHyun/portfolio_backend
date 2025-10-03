package com.ldh.portfolio.service.project;

import com.ldh.portfolio.builder.project.ProjectDtoMapper;
import com.ldh.portfolio.domain.course.Course;
import com.ldh.portfolio.domain.project.ProjectHeader;
import com.ldh.portfolio.domain.project.ProjectImage;
import com.ldh.portfolio.domain.project.ProjectItem;
import com.ldh.portfolio.domain.project.ProjectOrigin;
import com.ldh.portfolio.dto.project.ProjectItemDetailDTO;
import com.ldh.portfolio.dto.project.request.item.ProjectImageUpsertDTO;
import com.ldh.portfolio.dto.project.request.item.ProjectItemCreateRequest;
import com.ldh.portfolio.dto.project.request.item.ProjectItemUpdateRequest;
import com.ldh.portfolio.repository.course.CourseRepository;
import com.ldh.portfolio.repository.project.ProjectHeaderRepository;
import com.ldh.portfolio.repository.project.ProjectImageRepository;
import com.ldh.portfolio.repository.project.ProjectItemRepository;
import com.ldh.portfolio.repository.project.ProjectItemSnippetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ProjectItemServiceImpl implements ProjectItemService {

    private final ProjectItemRepository itemRepo;
    private final ProjectHeaderRepository headerRepo;
    private final CourseRepository courseRepo;
    private final ProjectImageRepository imageRepo;
    private final ProjectDtoMapper mapper;
    private final ProjectItemSnippetRepository snippetRepo;

    @Override
    @Transactional(readOnly = true)
    public List<ProjectItem> listByHeader(Long headerId) {
        return itemRepo.findByHeader_IdOrderByYearDescIdDesc(headerId);
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectItemDetailDTO detail(Long itemId) {
        ProjectItem item = itemRepo.findWithImagesById(itemId);
        if (item == null) throw new ResponseStatusException(NOT_FOUND);
        return mapper.toItemDetail(item);
    }


    @Override
    @Transactional
    public Long create(ProjectItemCreateRequest req) {
        ProjectHeader header = headerRepo.findById(req.getHeaderId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Header not found"));

        Course course = null;
        if (req.getOrigin() == ProjectOrigin.COURSE && req.getCourseId() != null) {
            course = courseRepo.findById(req.getCourseId())
                    .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "Course not found"));
        }

        ProjectItem item = ProjectItem.builder()
                .header(header)
                .origin(req.getOrigin())
                .course(course)
                .title(req.getTitle())
                .summary(req.getSummary())
                .description(req.getDescription())
                .year(req.getYear())
                .demoUrl(req.getDemoUrl())
                .githubUrl(req.getGithubUrl())
                .techStacks(normalizeStacks(req.getTechStacks()))
                .build();

        List<ProjectImage> images = upsertImages(new ArrayList<>(), req.getImages());
        images.forEach(img -> img.setProject(item));
        item.setImages(images);

        ensureSinglePrimary(item.getImages());

        return itemRepo.save(item).getId();
    }

    @Override
    @Transactional
    public void update(Long itemId, ProjectItemUpdateRequest req) {

        ProjectItem item = itemRepo.findWithImagesById(itemId);
        if (item == null) throw new ResponseStatusException(NOT_FOUND);

        if (req.getHeaderId() != null) {
            ProjectHeader newHeader = headerRepo.findById(req.getHeaderId())
                    .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Header not found"));
            item.setHeader(newHeader);
        }

        if (req.getOrigin() != null) item.setOrigin(req.getOrigin());

        if (req.getCourseId() != null) {
            if (item.getOrigin() != ProjectOrigin.COURSE) {
                throw new ResponseStatusException(BAD_REQUEST, "courseId allowed only when origin=COURSE");
            }

            Course course = courseRepo.findById(req.getCourseId())
                    .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "Course not found"));
            item.setCourse(course);
        }

        if (req.getTitle() != null) item.setTitle(req.getTitle());
        if (req.getSummary() != null) item.setSummary(req.getSummary());
        if (req.getDescription() != null) item.setDescription(req.getDescription());
        if (req.getYear() != null) item.setYear(req.getYear());
        if (req.getDemoUrl() != null) item.setDemoUrl(req.getDemoUrl());
        if (req.getGithubUrl() != null) item.setGithubUrl(req.getGithubUrl());

        if (req.getTechStacks() != null) {
            item.setTechStacks(normalizeStacks(req.getTechStacks()));
        }


        if (req.getImages() != null) {
            List<ProjectImage> merged = upsertImages(item.getImages(), req.getImages());
            merged.forEach(img -> img.setProject(item));

            item.getImages().clear();
            item.getImages().addAll(merged);
        }

        ensureSinglePrimary(item.getImages());
    }

    @Override
    @Transactional
    public void delete(Long itemId) {

        ProjectItem item = itemRepo.findWithImagesById(itemId);
        if (item == null) throw new ResponseStatusException(NOT_FOUND);

        snippetRepo.deleteByProjectItem(item);
        itemRepo.delete(item);
    }


    private void ensureSinglePrimary(List<ProjectImage> images) {

        long primaries = images.stream().filter(ProjectImage::isPrimaryImage).count();
        if (primaries > 1) {
            throw new ResponseStatusException(BAD_REQUEST, "Only one primary image is allowed.");
        }

        if (primaries == 0 && !images.isEmpty()) {
            images.get(0).setPrimaryImage(true);
        }
    }

    private List<ProjectImage> upsertImages(List<ProjectImage> current, List<ProjectImageUpsertDTO> reqList) {

        if (reqList == null) return current; // no change
        if (reqList.isEmpty()) return new ArrayList<>(); // delete all

        Map<Long, ProjectImage> currentMap = current.stream()
                .filter(img -> img.getId() != null)
                .collect(Collectors.toMap(ProjectImage::getId, Function.identity()));

        List<ProjectImage> result = new ArrayList<>(reqList.size());
        for (ProjectImageUpsertDTO dto : reqList) {
            if (dto.getId() != null) {
                // update existing
                ProjectImage img = currentMap.get(dto.getId());
                if (img == null) {

                    throw new ResponseStatusException(BAD_REQUEST, "Image id not found: " + dto.getId());
                }
                img.setImageUrl(dto.getImageUrl());
                img.setAltText(dto.getAltText());
                img.setSortOrder(dto.getSortOrder());
                img.setPrimaryImage(Boolean.TRUE.equals(dto.getPrimaryImage()));
                img.setWidth(dto.getWidth());
                img.setHeight(dto.getHeight());
                result.add(img);
            } else {
                // create new
                ProjectImage img = ProjectImage.builder()
                        .imageUrl(dto.getImageUrl())
                        .altText(dto.getAltText())
                        .sortOrder(dto.getSortOrder())
                        .primaryImage(Boolean.TRUE.equals(dto.getPrimaryImage()))
                        .width(dto.getWidth())
                        .height(dto.getHeight())
                        .build();
                result.add(img);
            }
        }

        result.sort(Comparator.comparing(ProjectImage::getSortOrder));
        return result;
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
