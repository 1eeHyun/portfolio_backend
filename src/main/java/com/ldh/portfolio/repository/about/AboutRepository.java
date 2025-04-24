package com.ldh.portfolio.repository.about;

import com.ldh.portfolio.domain.about.About;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AboutRepository extends JpaRepository<About, Long> {
}
