package com.faceye.elasticsearch.service.impl;


import java.util.ArrayList;
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
	public void multiDocSave(int size) {
		long now=System.currentTimeMillis();
		logger.debug(">>FaceYe start time is:"+now);
		long start=System.currentTimeMillis();
		for(int i=0;i<size;i++){
			ElasticsearchDocument doc=new ElasticsearchDocument();
			doc.setAge(i*10);
			doc.setId(new Long(i));
			doc.setName("jack - "+i);
			this.save(doc);
			if(i%100 ==0){
				logger.debug(">>FaceYe store 100 record 2 ES cost :"+(System.currentTimeMillis()-start) +"  mill seconds,total record is:"+i);
				start=System.currentTimeMillis();
			}
		}
		logger.debug(">>FaceYe store "+size+" record t0 ES cost :"+(System.currentTimeMillis()-now)+" mill seconds");
	}

	@Override
	public void batchMultiDocSave(int start, int end) {
		long now=System.currentTimeMillis();
		logger.debug(">>FaceYe start time is:"+now);
		long begin=System.currentTimeMillis();
		List<ElasticsearchDocument> docs=new ArrayList<ElasticsearchDocument>(0);
		for(int i=start;i<end;i++){
			ElasticsearchDocument doc=new ElasticsearchDocument();
			doc.setAge(i*10);
			doc.setId(new Long(i));
			doc.setName("jack - "+i);
			doc.setStr1("JACK="+i);
			doc.setStr2("JACK="+i);
			doc.setStr3("JACK="+i);
			doc.setStr4("JACK="+i);
			doc.setStr5("JACK="+i);
			doc.setStr6("JACK="+i);
			doc.setStr7("JACK="+i);
			doc.setStr8("JACK="+i);
			docs.add(doc);
			if(i%100 ==0){
				this.elasticsearchDocumentRepository.save(docs);
				logger.debug(">>FaceYe store 100 record 2 ES cost :"+(System.currentTimeMillis()-begin) +"  mill seconds,total record is:"+i);
				begin=System.currentTimeMillis();
				docs=new ArrayList<ElasticsearchDocument>(0);
			}
		}
		
	}

	@Override
	public void update(ElasticsearchDocument elasticsearchDocument) {
		this.elasticsearchDocumentRepository.save(elasticsearchDocument);
		
	}
}
