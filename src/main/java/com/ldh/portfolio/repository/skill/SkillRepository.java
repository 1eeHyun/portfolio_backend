package com.ldh.portfolio.repository.skill;

import com.ldh.portfolio.domain.skill.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    boolean existsByName(String name);
}
