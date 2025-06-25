package com.ldh.portfolio.controller.course;

import com.ldh.portfolio.dto.course.CourseResponseDTO;
import com.ldh.portfolio.service.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController implements CourseApiDocs {

    private final CourseService courseService;

    @Override
    @GetMapping
    public ResponseEntity<List<CourseResponseDTO>> getCourse() {
        return ResponseEntity.ok(courseService.get());
    }
}
