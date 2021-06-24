package com.test.listen;

import java.util.function.Function;
import java.util.function.Supplier;

public class ReloadEvent implements Event{
    private String[] keys;

    public String[] getKeys() {
        return keys;
    }

    public void setKeys(String[] keys) {
        this.keys = keys;
    }
}
