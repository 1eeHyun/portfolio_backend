package com.ldh.portfolio.dto.course;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseResponseDTO {

    private Long id;
    private Integer year;
    private String name;
    private String description;
    private String logoUrl;
}
