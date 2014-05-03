package com.mydog.search;

import com.mydog.core.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchEngineImpl implements SearchEngine {

    @Autowired
    SearchRepository contentRepository;

    @Override
    public SearchResultWrapper search(SearchDefinition definition) throws SearchException {
        return null;
    }
}
