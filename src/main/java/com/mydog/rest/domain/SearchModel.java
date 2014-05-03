package com.mydog.rest.domain;

import com.mydog.search.KeywordFilter;
import com.mydog.search.SearchDefinition;

public class SearchModel {

    private String keyword;

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public SearchDefinition createSearchDefinition() {
        return new SearchDefinition()
            .addFilter(KeywordFilter.keyword(keyword));
    }

}
