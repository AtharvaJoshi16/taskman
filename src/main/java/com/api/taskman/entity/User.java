package com.api.taskman.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
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
}
