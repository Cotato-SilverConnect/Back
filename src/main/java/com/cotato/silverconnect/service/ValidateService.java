package com.cotato.silverconnect.service;

import com.cotato.silverconnect.domain.entity.Dong;
import com.cotato.silverconnect.domain.entity.Gu;
import com.cotato.silverconnect.repository.DongRepository;
import com.cotato.silverconnect.repository.GuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ValidateService {
    private final GuRepository guRepository;
    private final DongRepository dongRepository;

    public Gu findGuByName(String guName) {
        return guRepository.findByName(guName).get();
    }

    public Dong findDongByAddress(String address) {
        String[] addressSplit = address.split(" ");
        return findDongByName(addressSplit[2]);
    }

    public Dong findDongByName(String dongName) {
        return dongRepository.findByName(dongName).get();
    }
}
