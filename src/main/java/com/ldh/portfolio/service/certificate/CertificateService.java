package com.ldh.portfolio.service.certificate;

import com.ldh.portfolio.dto.certificate.CertificateRequestDTO;
import com.ldh.portfolio.dto.certificate.CertificateResponseDTO;

import java.util.List;

public interface CertificateService {

    CertificateResponseDTO create(CertificateRequestDTO dto);
    List<CertificateResponseDTO> getAll();
}
