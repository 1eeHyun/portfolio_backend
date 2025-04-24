package com.ldh.portfolio.controller.course;

import com.ldh.portfolio.dto.course.CourseResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course")
public class CourseController implements CourseApiDocs {


    @Override
    public ResponseEntity<CourseResponseDTO> getCourse() {
        return null;
    }
}
