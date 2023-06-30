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
public class PostResponseDto {
    String title;
    String content;
    String username;
    String category;
    LocalDateTime createdAt;
    LocalDateTime eventDate;
    String dongName;
    String guName;
    Long limitParticipantNum;
    Long currentParticipantNum;
    boolean isRecruiting;
    List<String> participants;

    public static PostResponseDto toDto(Post post, String guName, String dongName, boolean isRecruiting, Long currentParticipantNum, List<String> participants) {
        return PostResponseDto.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .username(post.getUser().getUsername())
                .category(post.getCategory())
                .createdAt(post.getCreatedAt())
                .eventDate(post.getEventDate())
                .dongName(dongName)
                .guName(guName)
                .limitParticipantNum(post.getLimitParticipantNum())
                .isRecruiting(isRecruiting)
                .currentParticipantNum(currentParticipantNum)
                .participants(participants)
                .build();
    }
}
