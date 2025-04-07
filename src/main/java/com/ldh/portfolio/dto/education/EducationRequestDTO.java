package com.ldh.portfolio.dto.education;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationRequestDTO {

    private String schoolName;
    private String major;
    private String degree;
    private String startDate;
    private String endDate;
}

