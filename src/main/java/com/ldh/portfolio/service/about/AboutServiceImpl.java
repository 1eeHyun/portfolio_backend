package com.ldh.portfolio.service.about;

import com.ldh.portfolio.builder.about.AboutResponseBuilder;
import com.ldh.portfolio.domain.about.About;
import com.ldh.portfolio.dto.about.AboutRequestDTO;
import com.ldh.portfolio.dto.about.AboutResponseDTO;
import com.ldh.portfolio.repository.about.AboutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AboutServiceImpl implements AboutService {

    private final AboutRepository aboutRepository;
    private final AboutResponseBuilder responseBuilder;


    @Override
    public AboutResponseDTO get() {

        About about = aboutRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new RuntimeException("About not found"));
        return responseBuilder.toDTO(about);
    }

    @Override
    public AboutResponseDTO createOrUpdate(AboutRequestDTO dto) {

        About about = aboutRepository.findAll().stream().findFirst().orElse(new About());

        about.setInterests(dto.getInterests());
        about.setFullBio(dto.getFullBio());
        about.setGithubUrl(dto.getGithubUrl());
        about.setHeroSubtitle(dto.getHeroSubtitle());
        about.setInterests(dto.getInterests());
        about.setLinkedInUrl(dto.getLinkedInUrl());
        about.setProfileImageUrl(dto.getProfileImageUrl());
        about.setSubBio(dto.getSubBio());
        return responseBuilder.toDTO(aboutRepository.save(about));
    }
}
