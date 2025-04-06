package com.ldh.portfolio.domain.project;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String featureTitle;
    private String imageUrl;
    private String techUsed;
    private String description;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
