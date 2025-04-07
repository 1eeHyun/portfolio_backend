package com.ldh.portfolio.controller.certificate;

import com.ldh.portfolio.dto.certificate.CertificateResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "Certificate API", description = "Public API to view certificates")
@RequestMapping("/api/certificates")
public interface CertificateApiDocs {

    @GetMapping
    @Operation(summary = "Get all certificates", description = "Retrieve all stored certificates")
    ResponseEntity<List<CertificateResponseDTO>> getAll();
}
