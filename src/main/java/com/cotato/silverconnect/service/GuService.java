package com.cotato.silverconnect.service;

import com.cotato.silverconnect.domain.dto.GuDto;
import com.cotato.silverconnect.repository.GuRepository;
import com.cotato.silverconnect.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class GuService {
    private final JsonUtil jsonUtil;
    private final GuRepository guRepository;

    @Transactional
    public void initGu() {
        String areaInfoJson = jsonUtil.readFileAsString("json/dong_coords.json");
        JSONArray areaInfoArray = jsonUtil.parseJsonArray(areaInfoJson, "areaInfo");

        for (Object areaObj : areaInfoArray) {
            JSONObject areaObjJson = (JSONObject) areaObj;

            String guName = areaObjJson.get("gu").toString();
            double latitude = (double) areaObjJson.get("lat");
            double longitude = (double) areaObjJson.get("lng");

            // 구 초기화 중복 방지
            if (guRepository.existsByName(guName)) {
                continue;
            }

            System.out.println(guName);
            GuDto guDto = GuDto.builder()
                    .name(guName)
                    .latitude(latitude)
                    .longitude(longitude)
                    .build();
            guRepository.save(guDto.toEntity());

        }
    }

}
