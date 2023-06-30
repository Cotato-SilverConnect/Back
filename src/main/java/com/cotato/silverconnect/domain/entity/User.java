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

    private String username;
    private long like_num;
    private long mvp_num;

    @Builder
    public User(String username, long like_num, long mvp_num) {
        this.username = username;
        this.like_num = like_num;
        this.mvp_num = mvp_num;
    }
}