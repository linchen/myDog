package com.mydog.search;

import org.springframework.util.StringUtils;

public class KeywordFilter implements SearchDefinition.Filter {

    private final String keyword;
    public static KeywordFilter keyword(String keyword) {
        return StringUtils.isEmpty(keyword) || keyword.trim().isEmpty()? null: new KeywordFilter(keyword);
    }

    public KeywordFilter(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (this.keyword == null ? 0 : this.keyword.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        KeywordFilter other = (KeywordFilter) obj;
        if (this.keyword == null) {
            if (other.keyword != null) {
                return false;
            }
        } else if (!this.keyword.equals(other.keyword)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("KeywordFilter [keyword=").append(this.keyword).append("]");
        return builder.toString();
    }
}
