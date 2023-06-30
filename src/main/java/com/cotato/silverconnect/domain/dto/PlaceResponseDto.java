package com.cotato.silverconnect.domain.dto;

import com.cotato.silverconnect.domain.entity.Place;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaceResponseDto {
    Long id;
    String placeName;
    double latitude;
    double longitude;
    String imageUrl;
    String content;

    public static PlaceResponseDto toDto(Place place){
        return PlaceResponseDto.builder()
                .placeName(place.getPlaceName())
                .content(place.getContent())
                .imageUrl(place.getImageUrl())
                .id(place.getId())
                .longitude(place.getLongitude())
                .latitude(place.getLatitude())
                .build();
    }

    @Override
    public String toString() {
        return "PlaceResponseDto{" +
                "id=" + id +
                ", placeName='" + placeName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", imageUrl='" + imageUrl + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
