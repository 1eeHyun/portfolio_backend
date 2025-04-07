package com.ldh.portfolio.validator.about;

import com.ldh.portfolio.repository.about.AboutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AboutValidator {

    private final AboutRepository aboutRepository;

//    public AboutResponseDTO validateAbout() {
//        return aboutRepository.findAll().stream().findFirst()
//                .orElseThrow(() -> new RuntimeException("About not found"));
//    }
}
