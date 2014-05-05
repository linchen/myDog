package com.mydog.core.events;

/**
 * Created by Lin on 21.04.14.
 */
public class DeletedEvent {
    protected boolean entityFound = true;

    public boolean isEntityFound() {
        return entityFound;
    }
}
