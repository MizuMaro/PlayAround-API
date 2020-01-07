package com.playaround.playaroundapi.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UpdateSessionRequest implements Serializable {
    private int id;
    private String token;
    private String  author;
    private String name;
    private String gameId;
    private Date date;
    private String place;
    private boolean visibility;
    private String limit;
    private String type;
    private List<Integer> userIds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UpdateSessionRequest() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }

    public UpdateSessionRequest(int id, String token, String author, String name, String gameId, Date date, String place, boolean visibility, String limit, String type, List<Integer> userIds) {
        this.setId(id);
        this.setAuthor(author);
        this.setName(name);
        this.setGameId(gameId);
        this.setDate(date);
        this.setPlace(place);
        this.setVisibility(visibility);
        this.setLimit(limit);
        this.setType(type);
        this.setToken(token);
        this.setUserIds(userIds);
    }
}
