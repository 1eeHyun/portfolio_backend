package com.ldh.portfolio.validator;

import com.ldh.portfolio.dto.ProjectRequestDTO;
import com.ldh.portfolio.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProjectValidator {

    private final ProjectRepository projectRepository;

    public void validateCreate(ProjectRequestDTO dto) {
        if (projectRepository.existsByTitle(dto.getTitle())) {
            throw new IllegalArgumentException("Already existed title.");
        }
    }
}
