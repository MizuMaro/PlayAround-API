package com.playaround.playaroundapi.models;

import com.playaround.playaroundapi.bo.UserPA;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UpdateUserInfoRequest implements Serializable {
    private String bio;
    private Date birthDate;
    private String location;
    private String imageUrl;

    public UpdateUserInfoRequest(String bio, Date birthDate, String location, String imageUrl) {
        this.bio = bio;
        this.birthDate = birthDate;
        this.location = location;
        this.imageUrl = imageUrl;
    }

    public UpdateUserInfoRequest() {
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;

    }
}
