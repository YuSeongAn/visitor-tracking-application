package com.numble.visitor.domain.repository;

import com.numble.visitor.domain.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SiteRepository extends JpaRepository<Site, Long> {
    Optional<Site> findSiteBySiteRootPath(String siteRootPath);
}
