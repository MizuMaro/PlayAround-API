package com.playaround.playaroundapi.models;

public class JoinSessionRequest {

    private int id;
    private String token;

    public JoinSessionRequest(int id, String token) {
        this.setId(id);
        this.setToken(token);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
