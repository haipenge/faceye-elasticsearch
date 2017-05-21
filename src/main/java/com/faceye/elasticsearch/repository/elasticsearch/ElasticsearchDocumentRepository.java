package com.faceye.elasticsearch.repository.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.faceye.elasticsearch.entity.ElasticsearchDocument;



public interface ElasticsearchDocumentRepository extends ElasticsearchCrudRepository<ElasticsearchDocument,Long> {
	public ElasticsearchDocument getElasticsearchDocumentByName(String name);
}
