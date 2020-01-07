package com.playaround.playaroundapi.bo;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PA_Session")
public class SessionPA {

    @Id
    @GeneratedValue
    private int id;
    @Column(name="author")
    private String userId;
    @Column(name="name")
    private String name;
    @Column(name="game")
    private String gameId;
    @Column(name = "image")
    private String imageUrl;
    @Column(name="date")
    private Date date;
    @Column(name = "place")
    private String place;
    @Column(name = "visibility")
    private boolean visibility;
    @Column(name = "limitation")
    private String limitation;
    @Column(name = "types")
    private String type;
    @ElementCollection
    @Column(name = "participants")
    private List<Integer> ids;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLimit() {
        return limitation;
    }

    public void setLimit(String limit) {
        this.limitation = limit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGame() {
        return gameId;
    }

    public void setGame(String game) {
        this.gameId = game;
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

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SessionPA() {
    }

    public SessionPA(String author, String name, String gameId, Date date, String place, boolean visibility, String limit, String type ) {
        this.name = name;
        this.userId = author ;
        this.gameId = gameId;
        this.date= date;
        this.place= place;
        this.visibility= visibility;
        this.limitation = limit;
        this.type = type;
        this.imageUrl= "";
    }
}
