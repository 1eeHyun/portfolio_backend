package com.ldh.portfolio.service.education;

import com.ldh.portfolio.domain.education.Education;
import com.ldh.portfolio.dto.education.EducationRequestDTO;
import com.ldh.portfolio.dto.education.EducationResponseDTO;
import com.ldh.portfolio.repository.education.EducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {

    private final EducationRepository educationRepository;

    @Override
    public EducationResponseDTO create(EducationRequestDTO dto) {

        Education education = Education.builder()
                .schoolName(dto.getSchoolName())
                .major(dto.getMajor())
                .degree(dto.getDegree())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .build();

        return toDTO(educationRepository.save(education));
    }

    @Override
    public List<EducationResponseDTO> getAll() {
        return educationRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    private EducationResponseDTO toDTO(Education edu) {
        return EducationResponseDTO.builder()
                .id(edu.getId())
                .schoolName(edu.getSchoolName())
                .major(edu.getMajor())
                .degree(edu.getDegree())
                .startDate(edu.getStartDate())
                .endDate(edu.getEndDate())
                .build();
    }
}
