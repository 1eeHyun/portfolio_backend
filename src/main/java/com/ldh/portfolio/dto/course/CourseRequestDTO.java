package com.ldh.portfolio.dto.course;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseRequestDTO {

    private String name;
    private String description;
    private String logoUrl;
}
