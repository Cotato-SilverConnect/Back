package com.cotato.silverconnect.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", timezone="Asia/Seoul")
    @CreationTimestamp
    private LocalDateTime createdAt;
    private LocalDateTime eventDate;

    private String place;
    private Long limitParticipantNum;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gu_id")
    private Gu gu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dong_id")
    private Dong dong;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Post(String title, String content, LocalDateTime createdAt, LocalDateTime eventDate, String place, Gu gu, Dong dong,User user) {
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.eventDate = eventDate;
        this.place = place;
        this.gu = gu;
        this.dong = dong;
        this.user = user;
    }
}
