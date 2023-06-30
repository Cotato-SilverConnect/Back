package com.cotato.silverconnect.controller;


import com.cotato.silverconnect.domain.dto.ApiResponse;
import com.cotato.silverconnect.domain.dto.UserResponseDto;
import com.cotato.silverconnect.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/{id}")
    public ApiResponse<UserResponseDto> getLikeCount(@PathVariable("id") Long id) {
        return ApiResponse.createSuccess(userService.getUserInfo(id));
    }




}
