package com.cotato.silverconnect.controller;

import com.cotato.silverconnect.domain.dto.ApiResponse;
import com.cotato.silverconnect.domain.dto.PostResponseDto;
import com.cotato.silverconnect.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.geom.PathIterator;
import java.net.FileNameMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping("/{id}")
    public ApiResponse<PostResponseDto> getPost(@PathVariable("id") Long id) {
        return ApiResponse.createSuccess(postService.getPost(id));
    }
}
