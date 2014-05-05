package com.mydog.search;

import java.util.LinkedHashSet;
import java.util.Set;

public class SearchDefinition {

    private final Set<Filter> filters;

    public Set<Filter> getFilters(){
        return this.filters;
    }

    public SearchDefinition() {
        this.filters = new LinkedHashSet<>();
    }

    public SearchDefinition addFilter(Filter filter) {
        if(filter != null) {
            this.filters.add(filter);
        }
        return this;
    }

    public SearchDefinition setFilter(Filter filter) {
        Filter currentFilter = getFilter(filter.getClass());
        if(currentFilter != null) {
            this.filters.remove(currentFilter);
        }
        this.addFilter(filter);
        return this;
    }


    public <F extends Filter> F getFilter(Class<F> filterType) {
        for(Filter filter: this.filters) {
            if(filterType.isInstance(filter)) {
                return (F)filter;
            }
        }
        return null;
    }
    public interface Filter {}

    public boolean containsKeywordFilter() {
        return getFilter(KeywordFilter.class) != null;
    }
}
