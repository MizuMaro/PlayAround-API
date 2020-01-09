package com.playaround.playaroundapi.models;

public class GetTokenRequest {

    private String token;

    public GetTokenRequest(String token) {
        this.setToken(token);
    }

    public GetTokenRequest() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
