package com.ldh.portfolio.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String summary;
    private String techStack;
    private String githubUrl;
    private String demoUrl;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<ProjectDetail> slides = new ArrayList<>();
}
