package com.playaround.playaroundapi.models;

import java.io.Serializable;

public class FavoriteGamesRequest implements Serializable {

    private String gameId;

    public FavoriteGamesRequest(String gameId){
        this.gameId = gameId;
    }

    public FavoriteGamesRequest(){ }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}
