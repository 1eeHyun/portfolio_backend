package com.ldh.portfolio.domain.about;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class About {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
