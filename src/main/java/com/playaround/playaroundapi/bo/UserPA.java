package com.playaround.playaroundapi.bo;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
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
