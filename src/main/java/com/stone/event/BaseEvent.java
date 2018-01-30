package com.stone.event;

/**
 * Created by chenghao on 5/12/17.
 */
public abstract class BaseEvent {
    public String getIdentifier() {
        return identifier;
    }
    private String identifier;
    public BaseEvent(String identifier){
        this.identifier=identifier;
    }
}
