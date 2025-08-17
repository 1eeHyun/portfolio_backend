package com.ldh.portfolio.controller.course;

import com.ldh.portfolio.dto.course.CourseRequestDTO;
import com.ldh.portfolio.dto.course.CourseResponseDTO;
import com.ldh.portfolio.service.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/courses")
public class AdminCourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseResponseDTO> create(@RequestBody CourseRequestDTO dto) {
        return ResponseEntity.ok(courseService.create(dto));
    }
}
