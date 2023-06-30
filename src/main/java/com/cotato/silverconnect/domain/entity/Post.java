package com.cotato.silverconnect.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post")
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    private String title;
    private String content;

    private Date created_at;
    private Date event_date;

    private String place;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gu_id")
    private Gu gu;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dong_id")
    private Dong dong;

    @Builder
    public Post(String title, String content, Date created_at, Date event_date, String place, Gu gu, Dong dong) {
        this.title = title;
        this.content = content;
        this.created_at = created_at;
        this.event_date = event_date;
        this.place = place;
        this.gu = gu;
        this.dong = dong;
    }
}
