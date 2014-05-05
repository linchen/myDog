package com.mydog.search;

public interface SearchEngine {
    SearchResultWrapper search(SearchDefinition definition) throws SearchException;
}
