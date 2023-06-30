package com.cotato.silverconnect.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "place")
@Getter
@Setter
@NoArgsConstructor
@Builder
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Long id;
    private String placeName;
    private double latitude;
    private double longitude;
    private String imageUrl;
    @Column(columnDefinition = "LONGTEXT")
    private String content;

    public Place(Long id, String placeName, double latitude, double longitude, String imageUrl, String content) {
        this.id = id;
        this.placeName = placeName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageUrl = imageUrl;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", placeName='" + placeName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", imageUrl='" + imageUrl + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
