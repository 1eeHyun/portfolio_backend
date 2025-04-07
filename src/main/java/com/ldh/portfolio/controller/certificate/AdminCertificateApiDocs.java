package com.ldh.portfolio.controller.certificate;

import com.ldh.portfolio.dto.certificate.CertificateRequestDTO;
import com.ldh.portfolio.dto.certificate.CertificateResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Admin Certificate API", description = "Admin-only API for managing certificates")
@RequestMapping("/api/admin/certificates")
public interface AdminCertificateApiDocs{

    @PostMapping
    @Operation(summary = "Add certificate", description = "Create a new certificate entry")
    ResponseEntity<CertificateResponseDTO> create(CertificateRequestDTO dto);
}
