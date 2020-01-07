package com.playaround.playaroundapi.models;

import java.io.Serializable;

public class NewSessionResponse implements Serializable {

    private final String name;
    private final int id;

    public NewSessionResponse(int id, String name ) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
