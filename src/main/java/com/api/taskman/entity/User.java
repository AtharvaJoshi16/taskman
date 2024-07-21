package com.api.taskman.entity;


import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "users")
public class User {

    @Id
    private String userId;
    @Column(unique = true)
    private String username;
    private String firstName;
    private String lastName;
    private String profileImage;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    @Lob
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Epic> epics;

    public User() {
    }

    public User(String userId, String username, String firstName, String lastName, String profileImage, String email, String password, List<Epic> epics) {
        this.userId = userId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileImage = profileImage;
        this.email = email;
        this.password = password;
        this.epics = epics;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User(String username, String firstName, String lastName, String profileImage, String email, String password, List<Epic> epics) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileImage = profileImage;
        this.email = email;
        this.password = password;
        this.epics = epics;
    }

    public User(String password, String username, String firstName, String lastName, String profileImage, String email) {
        this.password = password;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileImage = profileImage;
        this.email = email;
    }




    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Epic> getEpics() {
        return epics;
    }

    public void setEpics(List<Epic> epics) {
        this.epics = epics;
    }
}
