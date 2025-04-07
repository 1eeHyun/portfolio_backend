package com.ldh.portfolio.service.education;

import com.ldh.portfolio.dto.education.EducationRequestDTO;
import com.ldh.portfolio.dto.education.EducationResponseDTO;

import java.util.List;

public interface EducationService {

    EducationResponseDTO create(EducationRequestDTO dto);
    List<EducationResponseDTO> getAll();
}
