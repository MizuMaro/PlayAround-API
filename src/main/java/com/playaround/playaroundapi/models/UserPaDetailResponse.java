package com.playaround.playaroundapi.models;

import com.playaround.playaroundapi.bo.UserPA;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.util.Date;
import java.util.List;

public class UserPaDetailResponse {
    private String email;
    private String username;
    private String role;
    private String bio;
    private Date birthDate;
    private String location;
    private List<Integer> games;
    private List<Integer> boardGames;
    private List<Integer> TCGames;
    private String imageUrl;
    private List<Integer> friendIds;
    private List<Integer> commuIds;

    public UserPaDetailResponse(UserPA user){
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.role = user.getRole();
        this.bio = user.getBio();
        this.birthDate = user.getBirthDate();
        this.location = user.getLocation();
        this.games = user.getGames();
        this.boardGames = user.getBoardGames();
        this.TCGames = user.getTCGames();
        this.imageUrl = user.getImageUrl();
        this.friendIds = user.getFriendIds();
        this.commuIds = user.getCommuIds();

    }

    public UserPaDetailResponse() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Integer> getGames() {
        return games;
    }

    public void setGames(List<Integer> games) {
        this.games = games;
    }

    public List<Integer> getBoardGames() {
        return boardGames;
    }

    public void setBoardGames(List<Integer> boardGames) {
        this.boardGames = boardGames;
    }

    public List<Integer> getTCGames() {
        return TCGames;
    }

    public void setTCGames(List<Integer> TCGames) {
        this.TCGames = TCGames;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Integer> getFriendIds() {
        return friendIds;
    }

    public void setFriendIds(List<Integer> friendIds) {
        this.friendIds = friendIds;
    }

    public List<Integer> getCommuIds() {
        return commuIds;
    }

    public void setCommuIds(List<Integer> commuIds) {
        this.commuIds = commuIds;
    }
}
