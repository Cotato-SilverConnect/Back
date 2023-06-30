package com.cotato.silverconnect.repository;

import com.cotato.silverconnect.domain.dto.PlaceResponseDto;
import com.cotato.silverconnect.domain.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    String HAVERSINE_FORMULA = "(6371 * acos(cos(radians(:latitude)) * cos(radians(s.latitude)) *" +
            " cos(radians(s.longitude) - radians(:longitude)) + sin(radians(:latitude)) * sin(radians(s.latitude))))";

    @Query("SELECT s FROM Place s WHERE " + HAVERSINE_FORMULA + " < :distance ORDER BY " + HAVERSINE_FORMULA + " ASC ")
    List<Place> findAllWtihInDistance(@Param("longitude") double longitude,
                                                 @Param("latitude") double latitude,
                                                 @Param("distance") double distanceWithInKM);
}
