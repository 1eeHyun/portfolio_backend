package com.ldh.portfolio.domain.project;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@Table(indexes = {
        @Index(name = "idx_project_image_project_sort", columnList = "project_id, sortOrder")
})
public class ProjectImage {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Public URL (S3/CDN) */
    @Column(nullable = false, length = 1024)
    private String imageUrl;

    @Column(length = 255)
    private String altText;

    /** Display order (ascending) */
    @Column(nullable = false)
    private Integer sortOrder;

    /** Mark one as primary if needed (enforce in service) */
    @Column(nullable = false)
    private boolean primaryImage = false;

    /** Optional dimensions for layout optimization */
    private Integer width;
    private Integer height;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ProjectItem project;
}
