package com.ldh.portfolio.repository.project;

import com.ldh.portfolio.domain.project.ProjectItem;
import com.ldh.portfolio.domain.project.ProjectOrigin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface ProjectItemRepository extends JpaRepository<ProjectItem, Long> {

    List<ProjectItem> findByHeader_IdOrderByYearDescIdDesc(Long headerId);

    Page<ProjectItem> findByHeader_Id(Long headerId, Pageable pageable);

    List<ProjectItem> findAllByOriginOrderByYearDescIdDesc(ProjectOrigin origin);

    @EntityGraph(attributePaths = {"images"})
    @Query("select p from ProjectItem p where p.id = :id")
    ProjectItem findWithImagesById(@Param("id") Long id);

    long countByHeader_Id(Long headerId);

    @Query("""
        select p.header.id as headerId, count(p.id) as projectCount
        from ProjectItem p
        where p.header.id in :headerIds
        group by p.header.id
    """)
    List<HeaderCountView> countByHeaderIds(@Param("headerIds") Collection<Long> headerIds);

    interface HeaderCountView {
        Long getHeaderId();
        long getProjectCount();
    }

    /** techStacks element-collection  (any-match) */
    @Query("""
        select distinct p from ProjectItem p
        join p.techStacks t
        where t in :techs
        order by p.year desc, p.id desc
    """)
    List<ProjectItem> searchByAnyTech(@Param("techs") Collection<String> techs);

    List<ProjectItem> findByCourse_IdOrderByYearDescIdDesc(Long courseId);

    @Query("select i from ProjectItem i where i.header.id = :headerId")
    List<ProjectItem> findAllByHeaderId(@Param("headerId") Long headerId);
}
