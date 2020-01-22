package com.playaround.playaroundapi.bo;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Account")
public class UserPA {

    @Id
    @GeneratedValue
    private int id;
    @Column(name="email")
    private String email;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="role")
    private String role;
    @Column(name="bio")
    private String bio;
    @Column(name = "birthDate")
    private Date birthDate;
    @Column(name = "location")
    private String location;
    @ElementCollection
    @Column(name = "gamefavorites")
    private List<Integer> games;
    @ElementCollection
    @Column(name = "boardGamefavorites")
    private List<Integer> boardGames;
    @ElementCollection
    @Column(name = "TCGamefavorites")
    private List<Integer> TCGames;
    @Column(name = "userImage")
    private String imageUrl;
    @ElementCollection
    @Column(name = "friends")
    private List<Integer> friendIds;
    @ElementCollection
    @Column(name = "communities")
    private List<Integer> commuIds;

    public UserPA(){
    }
    public UserPA(String email,String username, String password){
        this.email=email;
        this.username=username;
        this.password = password;
        this.commuIds = new ArrayList<>();
        this.friendIds = new ArrayList<>();
        this.games = new ArrayList<>();
        this.boardGames = new ArrayList<>();
        this.TCGames = new ArrayList<>();
        this.bio = "";
        this.location = "";
        this.birthDate = new Date();
        this.role = "user";
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public void setUsername(String login) {
        this.username = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
