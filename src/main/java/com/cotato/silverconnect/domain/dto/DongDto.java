package com.cotato.silverconnect.domain.dto;

import com.cotato.silverconnect.domain.entity.Dong;
import com.cotato.silverconnect.domain.entity.Gu;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DongDto {
    Long id;
    private String name;
    private double latitude;
    private double longitude;

    @Builder
    public DongDto(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Dong toEntity(Gu gu) {
        return Dong.builder()
                .name(name)
                .latitude(latitude)
                .longitude(longitude)
                .gu(gu)
                .build();
    }
}
