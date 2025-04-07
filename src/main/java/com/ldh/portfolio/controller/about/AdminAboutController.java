package com.ldh.portfolio.controller.about;

import com.ldh.portfolio.dto.about.AboutRequestDTO;
import com.ldh.portfolio.dto.about.AboutResponseDTO;
import com.ldh.portfolio.service.about.AboutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminAboutController implements AdminAboutApiDocs {

    private final AboutService aboutService;
    @Override
    public ResponseEntity<AboutResponseDTO> createOrUpdate(@RequestBody AboutRequestDTO dto) {
        return ResponseEntity.ok(aboutService.createOrUpdate(dto));
    }
}
