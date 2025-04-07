package com.ldh.portfolio.controller.certificate;

import com.ldh.portfolio.controller.ApiBase;
import com.ldh.portfolio.dto.certificate.CertificateResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Certificate API", description = "Public API to view certificates")
public interface CertificateApiDocs extends ApiBase {

    @Operation(summary = "Get all certificates", description = "Retrieve all stored certificates")
    ResponseEntity<List<CertificateResponseDTO>> getAll();
}
