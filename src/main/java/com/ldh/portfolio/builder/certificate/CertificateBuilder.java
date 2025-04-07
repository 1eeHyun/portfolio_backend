package com.ldh.portfolio.builder.certificate;

import com.ldh.portfolio.domain.certificate.Certificate;
import com.ldh.portfolio.dto.certificate.CertificateResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class CertificateBuilder {

    public CertificateResponseDTO toDTO(Certificate cert) {
        return CertificateResponseDTO.builder()
                .id(cert.getId())
                .name(cert.getName())
                .issuer(cert.getIssuer())
                .issueDate(cert.getIssueDate())
                .credentialUrl(cert.getCredentialUrl())
                .build();
    }
}
