package com.cotato.silverconnect.domain.dto;

import com.cotato.silverconnect.domain.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostListResponseDto {
    String title;
    String username;
    String category;
    LocalDateTime eventDate;
    String dongName;
    String guName;
    Long limitParticipantNum;
    Long currentParticipantNum;
    boolean isRecruiting;

    public static PostListResponseDto toDto(Post post, Long currentParticipantNum, boolean isRecruiting) {
        return PostListResponseDto.builder()
                .title(post.getTitle())
                .username(post.getUser().getUsername())
                .category(post.getCategory())
                .eventDate(post.getEventDate())
                .dongName(post.getDong().getName())
                .guName(post.getGu().getName())
                .limitParticipantNum(post.getLimitParticipantNum())
                .isRecruiting(isRecruiting)
                .currentParticipantNum(currentParticipantNum)
                .build();
    }
}
