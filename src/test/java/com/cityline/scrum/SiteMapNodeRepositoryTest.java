package com.cityline.scrum;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SiteMapNodeRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private SiteMapNodeRepository siteMapNodeRepository;

	@Test
	public void system_SHOULD_retrieve_node_with_its_parent() {
		// given
		SiteMapNode fooNode = new SiteMapNode();
		fooNode.setPageName("foo");
		fooNode.setParentNode(null);

		UUID fooNodeId = siteMapNodeRepository.save(fooNode).getSiteMapNodeId();

		SiteMapNode fooChildNode = new SiteMapNode();
		fooChildNode.setPageName("foo-child");
		fooChildNode.setParentNode(fooNode);

		UUID fooChildNodeId = siteMapNodeRepository.save(fooChildNode).getSiteMapNodeId();

		entityManager.flush();
		entityManager.clear();

		// when
		SiteMapNode savedFooChild = siteMapNodeRepository.findOne(fooChildNodeId);

		// then
		assertThat(savedFooChild.getPageName(), equalTo("foo-child"));
		assertThat(savedFooChild.getParentNode().getPageName(), equalTo("foo"));
	}

}
