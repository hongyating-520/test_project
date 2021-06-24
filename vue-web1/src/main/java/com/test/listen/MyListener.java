package com.test.listen;

/**
 * @author mima0000
 */
public abstract class MyListener<E extends Event> {

    abstract void doEvent(E event);

}
