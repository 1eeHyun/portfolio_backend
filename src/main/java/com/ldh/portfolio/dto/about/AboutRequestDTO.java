package com.ldh.portfolio.dto.about;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AboutRequestDTO {

    private String bio;
    private String location;
    private String email;
    private String interests;
    private String profileImageUrl;
}
