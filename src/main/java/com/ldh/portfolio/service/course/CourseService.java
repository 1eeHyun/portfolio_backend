package com.ldh.portfolio.service.course;

import com.ldh.portfolio.dto.course.CourseRequestDTO;
import com.ldh.portfolio.dto.course.CourseResponseDTO;

import java.util.List;

public interface CourseService {

    List<CourseResponseDTO> get();
    CourseResponseDTO create(CourseRequestDTO dto);
}
