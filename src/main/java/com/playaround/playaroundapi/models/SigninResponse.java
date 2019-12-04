package com.playaround.playaroundapi.models;


import com.playaround.playaroundapi.bo.UserPA;

import java.io.Serializable;

public class SigninResponse implements Serializable {

    private final String username;
    private final int id;

    public SigninResponse(int id,String username) {
        this.id = id;
        this.username = username;

    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }
}