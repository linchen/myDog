package com.mydog.content;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class InitElasticsearchDocument {

    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    Client client;

    public void saveOrUpdate(ElasticsearchDocument newProductDocument) {
        log.debug("Save document for hotel id={}", newProductDocument.getProductId());
        String json;
        try {
            json = objectMapper.writeValueAsString(newProductDocument);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
            return;
        }
        String existingDocumentId = retrieveIdOfExistingDocument(newProductDocument);
        IndexRequestBuilder indexRequest = client.prepareIndex(ElasticsearchDocument.INDEX, ElasticsearchDocument.TYPE)
            .setSource(json)
            .setRefresh(true);
        if(!StringUtils.isEmpty(existingDocumentId)) {
            log.trace("Updating existing document with document ID {}", existingDocumentId);
        }else {
            log.trace("Inserting new document {}", json);
        }
        indexRequest.execute().actionGet();
    }

    private String retrieveIdOfExistingDocument(ElasticsearchDocument document) {
        SearchResponse response = searchByContentId(document.getProductId());
        for(SearchHit hit: response.getHits()) {
            return hit.getId();
        }
        return null;
    }


    private SearchResponse searchByContentId(String id) {
        SearchResponse response = client.prepareSearch(ElasticsearchDocument.INDEX)
            .setTypes(ElasticsearchDocument.TYPE)
            .setSearchType(SearchType.DFS_QUERY_AND_FETCH)
            .setQuery(QueryBuilders.termQuery("productId",id))
            .setFrom(0).setSize(1).setExplain(false)
            .execute()
            .actionGet();
        return response;
    }



}
