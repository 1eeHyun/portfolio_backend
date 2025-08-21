package com.ldh.portfolio.domain.project;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;

@Entity
@Table(name = "project_item_snippet")
@Getter @Setter
public class ProjectItemSnippet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private ProjectItem projectItem;

    @Column(nullable = false, length = 120)
    private String title;

    @Column(nullable = false, length = 24)
    private String language;

    @Column(length = 255)
    private String filePath;

    @JdbcTypeCode(Types.LONGVARCHAR)
    @Column(columnDefinition = "LONGTEXT")
    private String code;

    private Integer startLine;
    private Integer endLine;

    @Column(nullable = false)
    private Integer displayOrder = 0;
}
