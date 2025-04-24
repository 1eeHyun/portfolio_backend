package com.ldh.portfolio.repository.about;

import com.ldh.portfolio.domain.about.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends JpaRepository<About, Long> {
}
