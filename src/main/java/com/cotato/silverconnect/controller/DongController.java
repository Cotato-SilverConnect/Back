package com.cotato.silverconnect.controller;

import com.cotato.silverconnect.service.DongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dong")
@RequiredArgsConstructor
public class DongController {
    private final DongService dongService;

    @GetMapping("/init-dong")
    public String initDong() {
        dongService.initDong();
        return "dong initialize success!";
    }

}
