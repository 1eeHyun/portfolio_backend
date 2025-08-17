package com.ldh.portfolio.service.course;

import com.ldh.portfolio.builder.course.CourseResponseBuilder;
import com.ldh.portfolio.domain.course.Course;
import com.ldh.portfolio.dto.course.CourseRequestDTO;
import com.ldh.portfolio.dto.course.CourseResponseDTO;
import com.ldh.portfolio.repository.course.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseResponseBuilder courseResponseBuilder;

    @Override
    public List<CourseResponseDTO> get() {

        return courseRepository.findAll().stream()
                .map(courseResponseBuilder::toDTO)
                .toList();
    }

    @Override
    public CourseResponseDTO create(CourseRequestDTO dto) {

        Course course = Course.builder()
                .name(dto.getName())
                .year(dto.getYear())
                .description(dto.getDescription())
                .logoUrl(dto.getLogoUrl())
                .build();

        return courseResponseBuilder.toDTO(courseRepository.save(course));
    }
}
