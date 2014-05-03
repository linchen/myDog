package com.mydog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mydog.content.InitElasticsearchDocument;
import org.elasticsearch.client.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.elasticsearch.client.NodeClientFactoryBean;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

@Configuration
@Profile("test")
public class ElasticsearchTestConfig {

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(elasticsearchClient());
    }

    @Bean
    public Client elasticsearchClient() throws Exception{
        final NodeClientFactoryBean nodeClientFactoryBean = new NodeClientFactoryBean(true);
        nodeClientFactoryBean.setClusterName("testCluster");
        nodeClientFactoryBean.setEnableHttp(false);
        nodeClientFactoryBean.afterPropertiesSet();
        final Client client = nodeClientFactoryBean.getObject();
        return client;
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public InitElasticsearchDocument initElasticsearchDocument() {
        return new InitElasticsearchDocument();
    }
}
