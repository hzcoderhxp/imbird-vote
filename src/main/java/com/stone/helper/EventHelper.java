package com.stone.helper;

import com.google.common.eventbus.EventBus;
import com.stone.event.BaseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenghao on 5/24/17.
 */

@Service
public class EventHelper {

    @Autowired
    private EventBus eventBus;
    public void postEvent(BaseEvent event) {
        eventBus.post(event);
    }
}
