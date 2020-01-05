package com.playaround.playaroundapi.bo;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Session")
public class SessionPA {

    @Id
    @GeneratedValue
    private int id;
    @Column(name="userIdCreator")
    private String userId;
    @Column(name="name")
    private String name;
    @Column(name="game")
    private String game;
    @Column(name="date")
    private Date date;
    @Column(name = "place")
    private String place;
    @Column(name = "visibility")
    private boolean visibility;
    @ElementCollection
    @Column(name = "participants")
    private List<Integer> ids;

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
        return game;
    }

    public void setGame(String game) {
        this.game = game;
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

    public SessionPA() {
    }
}
