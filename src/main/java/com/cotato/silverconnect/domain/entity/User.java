package com.cotato.silverconnect.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private Long age;
    private String username;
    private Long likeCount;
    private Long mvpCount;

    @Builder
    public User(String username, long likeCount, long mvpCount,Long age) {
        this.username = username;
        this.likeCount = likeCount;
        this.mvpCount = mvpCount;
        this.age = age;
    }
}