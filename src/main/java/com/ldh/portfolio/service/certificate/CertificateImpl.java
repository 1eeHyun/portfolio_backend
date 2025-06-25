package com.ldh.portfolio.service.certificate;

import com.ldh.portfolio.builder.certificate.CertificateBuilder;
import com.ldh.portfolio.domain.certificate.Certificate;
import com.ldh.portfolio.dto.certificate.CertificateRequestDTO;
import com.ldh.portfolio.dto.certificate.CertificateResponseDTO;
import com.ldh.portfolio.repository.certificate.CertificateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CertificateImpl implements CertificateService {

    private final CertificateRepository certificateRepository;
    private final CertificateBuilder certificateBuilder;

    @Override
    public CertificateResponseDTO create(CertificateRequestDTO dto) {

        Certificate cert = Certificate.builder()
                .name(dto.getName())
                .issuer(dto.getIssuer())
                .issueDate(dto.getIssueDate())
                .credentialUrl(dto.getCredentialUrl())
                .description(dto.getDescription())
                .build();

        return certificateBuilder.toDTO(certificateRepository.save(cert));
    }

    @Override
    public List<CertificateResponseDTO> getAll() {
        return certificateRepository.findAll().stream()
                .map(certificateBuilder::toDTO)
                .toList();
    }
}
