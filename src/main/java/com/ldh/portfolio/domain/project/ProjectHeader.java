package com.ldh.portfolio.domain.project;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@Table(indexes = {
        @Index(name = "idx_header_year_sort", columnList = "year, sortOrder, id")
})
public class ProjectHeader {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Card title */
    @Column(nullable = false, length = 120)
    private String title;

    /** Short subtitle for list card */
    @Column(length = 300)
    private String subtitle;

    /** Cover image for list card */
    private String coverImageUrl;

    /** For grouping/sorting (e.g., 2024) */
    private Integer year;

    /** Manual ordering inside the same year */
    private Integer sortOrder;

    /** Long description (shown on header detail when INTERNAL) */
    @Lob
    private String description;

    /** External links (open depending on displayMode) */
    private String liveUrl;
    private String githubUrl;
    private String docsUrl;
    private String videoUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private DisplayMode displayMode = DisplayMode.INTERNAL;

    /** Header-level tech stack badges */
    @ElementCollection
    @CollectionTable(name = "project_header_tech", joinColumns = @JoinColumn(name = "header_id"))
    @Column(name = "tech", length = 40, nullable = false)
    private Set<String> techStacks = new LinkedHashSet<>();
}
