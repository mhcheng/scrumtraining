package com.cityline.scrum;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteMapNodeRepository extends JpaRepository<SiteMapNode, UUID> {

}
