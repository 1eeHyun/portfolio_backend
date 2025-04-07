package com.ldh.portfolio.dto.certificate;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificateRequestDTO {

    private String name;
    private String issuer;
    private String issueDate;
    private String credentialUrl;
}
