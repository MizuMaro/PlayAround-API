package com.playaround.playaroundapi.models;

public class DeleteSessionRequest {
    private int sessionId;
    private String token;

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public DeleteSessionRequest() {
    }

    public DeleteSessionRequest(int sessionId, String token) {
        this.setSessionId(sessionId);
        this.setToken(token);
    }
}
