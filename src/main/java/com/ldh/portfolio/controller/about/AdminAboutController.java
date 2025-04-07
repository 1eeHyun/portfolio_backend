package com.ldh.portfolio.controller.about;

import com.ldh.portfolio.dto.about.AboutRequestDTO;
import com.ldh.portfolio.dto.about.AboutResponseDTO;
import com.ldh.portfolio.service.about.AboutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/about")
public class AdminAboutController {

    private final AboutService aboutService;

    @PostMapping
    public ResponseEntity<AboutResponseDTO> createOrUpdate(@RequestBody AboutRequestDTO dto) {
        return ResponseEntity.ok(aboutService.createOrUpdate(dto));
    }
}
