package com.ldh.portfolio.dto.project;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageDTO {
    private String url;
    private String alt;
    private Integer order;
    private Boolean primary;
    private Integer width;
    private Integer height;
}
