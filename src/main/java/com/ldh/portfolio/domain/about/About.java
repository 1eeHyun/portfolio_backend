package com.ldh.portfolio.domain.about;

import jakarta.persistence.*;
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

    @Column(columnDefinition = "TEXT")
    private String subBio;
    @Column(columnDefinition = "LONGTEXT")
    private String fullBio;

    private String email;
    private String interests;
    private String profileImageUrl;
}
