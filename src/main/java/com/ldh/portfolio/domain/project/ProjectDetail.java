package com.ldh.portfolio.domain;

import jakarta.persistence.*;

@Entity
public class ProjectDetail {

    @Id
    @GeneratedValue
    private Long id;

    private String featureTitle;
    private String imageUrl;
    private String techUsed;
    private String description;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
