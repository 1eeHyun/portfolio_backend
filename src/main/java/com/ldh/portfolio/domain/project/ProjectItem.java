package com.ldh.portfolio.domain.project;

import com.ldh.portfolio.domain.course.Course;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@Table(indexes = {
        @Index(name = "idx_item_header", columnList = "header_id"),
        @Index(name = "idx_item_year", columnList = "year"),
})
public class ProjectItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Which header this item belongs to */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ProjectHeader header;

    /** Personal or Course */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ProjectOrigin origin;

    /** If origin == COURSE, optional reference to Course (unidirectional) */
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    /** Item title */
    @Column(nullable = false, length = 150)
    private String title;

    /** Short summary for cards */
    @Column(length = 300)
    private String summary;

    /** Full description (markdown ok) */
    @Lob
    private String description;

    /** For grouping/sorting (e.g., 2024) */
    private Integer year;

    /** Optional links */
    private String demoUrl;    // mainly for PERSONAL
    private String githubUrl;  // optional

    /** Item-level tech stacks */
    @ElementCollection
    @CollectionTable(name = "project_item_tech", joinColumns = @JoinColumn(name = "project_item_id"))
    @Column(name = "tech", length = 40, nullable = false)
    private Set<String> techStacks = new LinkedHashSet<>();

    /** Item images (ordered) */
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("sortOrder ASC")
    private List<ProjectImage> images = new ArrayList<>();
}
