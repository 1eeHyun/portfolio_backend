package com.ldh.portfolio.builder.course;

import com.ldh.portfolio.domain.course.Course;
import com.ldh.portfolio.dto.course.CourseResponseDTO;

public class CourseResponseBuilder {

    public CourseResponseDTO toDTO(Course course) {
        return CourseResponseDTO.builder()
                .id(course.getId())
                .name(course.getName())
                .description(course.getDescription())
                .logoUrl(course.getLogoUrl())
                .build();
    }
}
