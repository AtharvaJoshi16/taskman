package com.api.taskman.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID userId;
    @Column(unique = true)
    private String username;
    private String profileImage;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    @Lob
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Epic> epics;

    public User(UUID userId, String username, String profileImage, String email, String password, List<Epic> epics) {
        this.userId = userId;
        this.username = username;
        this.profileImage = profileImage;
        this.email = email;
        this.password = password;
        this.epics = epics;
    }

    public User(String username, String profileImage, String email, String password) {
        this.username = username;
        this.profileImage = profileImage;
        this.email = email;
        this.password = password;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
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
