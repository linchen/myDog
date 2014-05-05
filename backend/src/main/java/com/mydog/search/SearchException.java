package com.mydog.search;

public class SearchException extends Exception {

    public SearchException(String message) {
        super(message);
    }

    public SearchException(String message, Throwable cause) {
        super(message, cause);
    }

}
