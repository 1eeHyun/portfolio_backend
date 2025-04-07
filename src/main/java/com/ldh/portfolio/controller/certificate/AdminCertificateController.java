package com.ldh.portfolio.controller.certificate;

import com.ldh.portfolio.dto.certificate.CertificateRequestDTO;
import com.ldh.portfolio.dto.certificate.CertificateResponseDTO;
import com.ldh.portfolio.service.certificate.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/certificates")
public class AdminCertificateController implements AdminCertificateApiDocs {

    private final CertificateService certificateService;

    @PostMapping
    public ResponseEntity<CertificateResponseDTO> create(@RequestBody CertificateRequestDTO dto) {
        return ResponseEntity.ok(certificateService.create(dto));
    }
}
