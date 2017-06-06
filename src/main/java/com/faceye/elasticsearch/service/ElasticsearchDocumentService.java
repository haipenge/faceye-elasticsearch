package com.faceye.elasticsearch.service;

import java.util.List;

import com.faceye.elasticsearch.entity.ElasticsearchDocument;


public interface ElasticsearchDocumentService {
	
	public ElasticsearchDocument get(Long id);
	public ElasticsearchDocument getElasticsearchDocumentByName(String name);
	public void save(ElasticsearchDocument elasticsearchDocument);
	public void save(List<ElasticsearchDocument> elasticsearchDocuments);
	public void update(ElasticsearchDocument elasticsearchDocument);
}
