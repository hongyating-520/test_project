package com.test.listen;

import org.springframework.stereotype.Component;

//@Component
public class RedisListener extends MyListener<ReloadEvent> {

    @Override
    void doEvent(ReloadEvent event) {
        System.out.println("reload event");
        for (String key : event.getKeys()) {
            System.out.println("key:"+key);
        }

    }
}
