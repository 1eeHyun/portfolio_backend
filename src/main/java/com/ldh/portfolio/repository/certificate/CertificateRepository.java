package com.ldh.portfolio.repository.certificate;

import com.ldh.portfolio.domain.certificate.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}
