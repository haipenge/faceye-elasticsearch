package com.faceye.elasticsearch.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.faceye.elasticsearch.entity.ElasticsearchDocument;


@RunWith(SpringRunner.class)
@SpringBootTest
@EnableElasticsearchRepositories(basePackages = {"com.faceye.elasticsearch.repository.elasticsearch"})
public class ElasticsearchDocumentServiceTestCase {
	private Logger logger=LoggerFactory.getLogger(ElasticsearchDocumentServiceTestCase.class);
	@Autowired
	private ElasticsearchDocumentService elasticsearchDocumentService = null;

	@Test
	public void testSave() throws Exception {
		ElasticsearchDocument edoc = new ElasticsearchDocument();
		edoc.setName("Jack");
		edoc.setAge(11);
		edoc.setId(1L);
		this.elasticsearchDocumentService.save(edoc);
		//ElasticsearchDocument doc =this.elasticsearchDocumentService.getElasticsearchDocumentByName("Jack");
		ElasticsearchDocument doc =this.elasticsearchDocumentService.get(1L);
		Assert.isTrue(doc!=null); 
	}
	
	@Test
	public void testUpdate() throws Exception{
		long start=System.currentTimeMillis();
		ElasticsearchDocument edoc=this.elasticsearchDocumentService.get(10L);
		edoc.setName("update_jack");
		this.elasticsearchDocumentService.update(edoc);
		logger.debug(">>Cost time is:"+(System.currentTimeMillis()-start));
		Assert.isTrue(true);
	}
}
