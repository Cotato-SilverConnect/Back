package com.cotato.silverconnect.service;

import com.cotato.silverconnect.domain.dto.PlaceResponseDto;
import com.cotato.silverconnect.domain.entity.Place;
import com.cotato.silverconnect.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceRepository placeRepository;

    public List<PlaceResponseDto> getAllNearPlaes(double longitude, double latitude) {
        List<Place> list = placeRepository.findAllWtihInDistance(longitude, latitude, 3);
        return list.stream()
                .map(PlaceResponseDto::toDto)
                .collect(Collectors.toList());
    }
}
