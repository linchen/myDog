package com.mydog.content;

import com.mydog.config.ElasticsearchTestConfig;
import com.mydog.content.fixture.ProductDataFixture;
import com.mydog.core.domain.Product;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ElasticsearchTestConfig.class)
@ActiveProfiles("test")
public class InitElasticsearchDocumentTest {

    private static final String CONTENT_ID = "1";
    private static final String TEST_INDEX = ElasticsearchDocument.INDEX;
    private static final String TEST_TYPE = ElasticsearchDocument.TYPE;

    @Autowired
    private InitElasticsearchDocument initElasticsearchDocument;

    private Map<String, Product> products = ProductDataFixture.createProduct();

    @Before
    public void setup() throws Exception {
        String json = initElasticsearchDocument.objectMapper
            .writeValueAsString(createTestDocument("h1"));
        System.out.println("json: " + json);
        initElasticsearchDocument.client.prepareIndex(TEST_INDEX, TEST_TYPE)
            .setSource(json)
            .setRefresh(true)
            .execute()
            .actionGet();
    }

    @Test
    public void testSaveOnly() {
        initElasticsearchDocument.saveOrUpdate(createTestDocument("h2"));
        SearchResponse response = initElasticsearchDocument.client.prepareSearch(TEST_INDEX)
            .setQuery(QueryBuilders.matchAllQuery()).execute().actionGet();
        assertNotNull(response.getHits());

        byte count = 0;
        for(SearchHit hit : response.getHits()) {
            System.out.println("hit:"+ (count+1) + hit.getSource());
            count++;
        }
        assertEquals(2, count);
    }

    @After
    public void tearDown() {
        DeleteIndexResponse delete = initElasticsearchDocument.client
            .admin()
            .indices()
            .delete(new DeleteIndexRequest(TEST_INDEX))
            .actionGet();
        if(!delete.isAcknowledged()) {
            System.out.println("Index wasn't deleted");
        }
        initElasticsearchDocument.client.close();
    }

    private  ElasticsearchDocument createTestDocument(String id) {
        ElasticsearchDocument document = new ElasticsearchDocument();
        document.setProductId(id);
        document.setProduct(products.get(id));
        return document;
    }
}
