package com.ldh.portfolio.domain.certificate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String issuer;
    private String issueDate;
    private String credentialUrl;

    @Column(columnDefinition = "TEXT")
    private String description;
}
