package com.cityline.scrum;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	SiteMapNodeRepository repository;

	@GetMapping("/foo")
	public String foo() {
		SiteMapNode node = new SiteMapNode();

		node.setPageName("foo");
		node.setParentNode(null);

		repository.save(node);

		return LocalDateTime.now().toString();
	}

}
