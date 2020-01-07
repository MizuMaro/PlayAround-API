package com.playaround.playaroundapi.models;

import java.io.Serializable;

public class UpdateSessionResponse implements Serializable {

    private final String name;
    private final int id;

    public UpdateSessionResponse(int id, String name ) {
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
