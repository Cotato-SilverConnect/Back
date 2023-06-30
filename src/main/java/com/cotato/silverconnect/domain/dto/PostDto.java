package com.cotato.silverconnect.domain.dto;

import com.cotato.silverconnect.domain.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    String title;
//    String guName;
    String dongName;
    LocalDateTime createdAt;

    public static PostDto toDto(Post post) {
        return PostDto.builder()
                .title(post.getTitle())
//                .guName(post.getGu().getName())
                .dongName(post.getDong().getName())
                .createdAt(post.getCreatedAt())
                .build();
    }


}
