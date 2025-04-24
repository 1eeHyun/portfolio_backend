package com.ldh.portfolio.controller.about;

import com.ldh.portfolio.dto.about.AboutResponseDTO;
import com.ldh.portfolio.service.about.AboutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/about")
public class AboutController implements AboutApiDocs {

    private final AboutService aboutService;

    @GetMapping
    public ResponseEntity<AboutResponseDTO> getAbout() {
        return ResponseEntity.ok(aboutService.get());
    }
}
