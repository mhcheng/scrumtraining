package com.cityline.scrum;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SiteMapNode {

	@Id
	@GeneratedValue
	private UUID siteMapNodeId;

	private String pageName;

	@OneToOne
	private SiteMapNode parentNode;

	public UUID getSiteMapNodeId() {
		return siteMapNodeId;
	}

	public void setSiteMapNodeId(UUID siteMapNodeId) {
		this.siteMapNodeId = siteMapNodeId;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public SiteMapNode getParentNode() {
		return parentNode;
	}

	public void setParentNode(SiteMapNode parentNode) {
		this.parentNode = parentNode;
	}

}
