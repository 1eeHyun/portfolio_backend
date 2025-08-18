package com.ldh.portfolio.validator.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProjectValidator {

//    private final ProjectRepository projectRepository;
//
////    public void validateCreate(ProjectRequestDTO dto) {
////        if (projectRepository.existsByTitle(dto.getTitle())) {
////            throw new IllegalArgumentException("Already existed title.");
////        }
////    }
//
//    public Project validateExists(Long id) {
//        return projectRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Project not found"));
//    }
}
