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
        about.setBio(dto.getBio());
        about.setLocation(dto.getLocation());
        about.setEmail(dto.getEmail());
        about.setInterests(dto.getInterests());
        about.setProfileImageUrl(dto.getProfileImageUrl());
        return responseBuilder.toDTO(aboutRepository.save(about));
    }
}
