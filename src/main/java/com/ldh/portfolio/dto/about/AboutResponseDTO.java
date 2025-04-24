package com.ldh.portfolio.dto.about;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AboutResponseDTO {

    private Long id;
    private String linkedInUrl;
    private String githubUrl;
    private String heroSubtitle;
    private String subBio;
    private String fullBio;
    private String email;
    private String interests;
    private String profileImageUrl;
}
