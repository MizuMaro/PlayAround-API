package com.playaround.playaroundapi.models;


import com.playaround.playaroundapi.bo.UserPA;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

    private final String jwt;
    private final String username;
    private final int id;
    private final String mail;

    public AuthenticationResponse(String jwt, UserPA user) {
        this.jwt = jwt;
        this.id = user.getId();
        this.mail = user.getEmail();
        this.username = user.getUsername();

    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getJwt() {
        return jwt;
    }
}