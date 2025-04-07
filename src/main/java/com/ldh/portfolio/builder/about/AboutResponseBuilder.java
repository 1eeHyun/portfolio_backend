package com.ldh.portfolio.builder.about;

import com.ldh.portfolio.domain.about.About;
import com.ldh.portfolio.dto.about.AboutResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class AboutResponseBuilder {

    public AboutResponseDTO toDTO(About about) {
        return AboutResponseDTO.builder()
                .id(about.getId())
                .bio(about.getBio())
                .location(about.getLocation())
                .email(about.getEmail())
                .interests(about.getInterests())
                .profileImageUrl(about.getProfileImageUrl())
                .build();
    }
}
