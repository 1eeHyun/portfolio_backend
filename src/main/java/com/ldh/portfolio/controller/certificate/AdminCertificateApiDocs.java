package com.ldh.portfolio.controller.certificate;

import com.ldh.portfolio.controller.ApiBase;
import com.ldh.portfolio.dto.certificate.CertificateRequestDTO;
import com.ldh.portfolio.dto.certificate.CertificateResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Admin Certificate API", description = "Admin-only API for managing certificates")
public interface AdminCertificateApiDocs extends ApiBase {

    @Operation(summary = "Add certificate", description = "Create a new certificate entry")
    ResponseEntity<CertificateResponseDTO> create(CertificateRequestDTO dto);
}
