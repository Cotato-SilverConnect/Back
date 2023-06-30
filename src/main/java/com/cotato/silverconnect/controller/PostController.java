package com.cotato.silverconnect.controller;

import com.cotato.silverconnect.domain.dto.ApiResponse;
import com.cotato.silverconnect.domain.dto.PostListResponseDto;
import com.cotato.silverconnect.domain.dto.PostResponseDto;
import com.cotato.silverconnect.domain.entity.Dong;
import com.cotato.silverconnect.domain.entity.Gu;
import com.cotato.silverconnect.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping("/{id}")
    public ApiResponse<PostResponseDto> getPost(@PathVariable("id") Long id) {
        return ApiResponse.createSuccess(postService.getPost(id));
    }

    @GetMapping("/list")
    public ApiResponse<List<PostListResponseDto>> getPostList(@RequestParam("category") String categoryName,
                                                              @RequestParam("gu") String guName, @RequestParam(value = "dong", required = false) String dongName) {
        return ApiResponse.createSuccess(postService.getPostList(categoryName, guName, dongName));
    }
}
