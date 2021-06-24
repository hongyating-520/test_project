package com.test.listen;

import org.springframework.stereotype.Component;

//@Component
public class UpdateListener extends MyListener<UpdateEvent>{
    @Override
    void doEvent(UpdateEvent event) {
        System.out.println("update event");
    }
}
