package com.ldh.portfolio.controller.certificate;

import com.ldh.portfolio.dto.certificate.CertificateResponseDTO;
import com.ldh.portfolio.service.certificate.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/certificates")
public class CertificateController implements CertificateApiDocs{

    private final CertificateService certificateService;

    @Override
    public ResponseEntity<List<CertificateResponseDTO>> getAll() {
        return ResponseEntity.ok(certificateService.getAll());
    }
}
