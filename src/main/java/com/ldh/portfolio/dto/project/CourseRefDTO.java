package com.ldh.portfolio.dto.project;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseRefDTO {
    private Long id;
    private String code;
    private String name;
    private Integer year;
    private String logoUrl;
}
