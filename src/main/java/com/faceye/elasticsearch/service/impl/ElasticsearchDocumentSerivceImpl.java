package com.faceye.elasticsearch.service.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faceye.elasticsearch.entity.ElasticsearchDocument;
import com.faceye.elasticsearch.repository.elasticsearch.ElasticsearchDocumentRepository;
import com.faceye.elasticsearch.service.ElasticsearchDocumentService;


@Service
public class ElasticsearchDocumentSerivceImpl implements ElasticsearchDocumentService {
	private Logger logger=LoggerFactory.getLogger(ElasticsearchDocumentSerivceImpl.class);
	@Autowired
	private ElasticsearchDocumentRepository elasticsearchDocumentRepository = null;

	@Override
	public void save(ElasticsearchDocument elasticsearchDocument) {
		this.elasticsearchDocumentRepository.save(elasticsearchDocument);
	}

	@Override
	public ElasticsearchDocument getElasticsearchDocumentByName(String name) {
		return this.elasticsearchDocumentRepository.getElasticsearchDocumentByName(name);
	}
	
	public ElasticsearchDocument get(Long id){
		return this.elasticsearchDocumentRepository.findOne(id);
	}

	
	@Override
	public void update(ElasticsearchDocument elasticsearchDocument) {
		this.elasticsearchDocumentRepository.save(elasticsearchDocument);
		
	}

	@Override
	public void save(List<ElasticsearchDocument> elasticsearchDocuments) {
		this.elasticsearchDocumentRepository.save(elasticsearchDocuments);
	}
}
