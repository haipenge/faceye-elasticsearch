package com.faceye.elasticsearch.service;

import com.faceye.elasticsearch.entity.ElasticsearchDocument;


public interface ElasticsearchDocumentService {
	public void save(ElasticsearchDocument elasticsearchDocument);
	public ElasticsearchDocument get(Long id);
	public ElasticsearchDocument getElasticsearchDocumentByName(String name);
	
	public void multiDocSave(int size);
	
	public void batchMultiDocSave(int start,int end);
	
	public void update(ElasticsearchDocument elasticsearchDocument);
}
