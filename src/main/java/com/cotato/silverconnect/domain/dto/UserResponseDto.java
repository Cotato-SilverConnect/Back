package com.cotato.silverconnect.domain.dto;

import com.cotato.silverconnect.domain.entity.Participant;
import com.cotato.silverconnect.domain.entity.Post;
import com.cotato.silverconnect.domain.entity.User;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {
    //Long id;
    Long age;
    String username;
    Long likeCount;
    Long mvpCount;
    Long participationCount;
    List<PostDto> posts;
    List<PostDto> participatedPosts;

    public static UserResponseDto toDto(User user, Long participationCount, List<PostDto> posts, List<PostDto> participatedPosts) {
        return UserResponseDto.builder()
                .age(user.getAge())
                .username(user.getUsername())
                .likeCount(user.getLikeCount())
                .mvpCount(user.getMvpCount())
                .participationCount(participationCount)
                .posts(posts)
                .participatedPosts(participatedPosts)
                .build();
    }
}
