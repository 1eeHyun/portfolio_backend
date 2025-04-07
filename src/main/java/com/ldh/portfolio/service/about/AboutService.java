package com.ldh.portfolio.service.about;

import com.ldh.portfolio.dto.about.AboutRequestDTO;
import com.ldh.portfolio.dto.about.AboutResponseDTO;

public interface AboutService {

    AboutResponseDTO get();
    AboutResponseDTO createOrUpdate(AboutRequestDTO dto);
}
