package com.cotato.silverconnect.controller;

import com.cotato.silverconnect.domain.dto.ApiResponse;
import com.cotato.silverconnect.domain.dto.PlaceResponseDto;
import com.cotato.silverconnect.domain.entity.Place;
import com.cotato.silverconnect.repository.PlaceRepository;
import com.cotato.silverconnect.service.PlaceService;
import com.cotato.silverconnect.utils.JsonUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/place")
public class PlaceController {
    private final PlaceRepository placeRepository;
    private final PlaceService placeService;
    private final JsonUtil jsonUtil;

    @GetMapping("/init")
    public String initPlace() {
        String areaInfoJson = jsonUtil.readFileAsString("json/park.json");
        JSONArray placeArray = jsonUtil.parseJsonArray(areaInfoJson, "DATA");
        for (Object placeObject : placeArray) {
            JSONObject placeJsonObject = (JSONObject) placeObject;

            Place place = Place.builder()
                    .placeName((String) placeJsonObject.get("p_park"))
                    .longitude(Double.parseDouble((String) placeJsonObject.get("longitude")))
                    .latitude(Double.parseDouble((String) placeJsonObject.get("latitude")))
                    .content((String) placeJsonObject.get("p_list_content"))
                    .imageUrl((String) placeJsonObject.get("p_img"))
                    .build();
            placeRepository.save(place);
        }
        return "dfsda";
    }

    @GetMapping("/")
    public ApiResponse<List<PlaceResponseDto>> getAllNearPlaces(@RequestParam double longitude, @RequestParam double latitude) {
        return ApiResponse.createSuccess(placeService.getAllNearPlaes(longitude, latitude));
    }
}
