package com.cotato.silverconnect.service;


import com.cotato.silverconnect.domain.dto.PostDto;
import com.cotato.silverconnect.domain.dto.UserResponseDto;
import com.cotato.silverconnect.domain.entity.Participant;
import com.cotato.silverconnect.domain.entity.Post;
import com.cotato.silverconnect.domain.entity.User;
import com.cotato.silverconnect.repository.ParticipantRepository;
import com.cotato.silverconnect.repository.PostRepository;
import com.cotato.silverconnect.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ParticipantRepository participantRepository;
    private final PostRepository postRepository;

    public UserResponseDto getUserInfo(Long userId) {
        User user = userRepository.findById(userId).get();
        return UserResponseDto.toDto(user, getParticipationCount(user), getPosts(user), getParticipatedPosts(user));
    }

//    @Transactional
//    public Long getLikeCount(Long userId) {
//        Optional<User> user = userRepository.findById(userId);
//        Long likeCount = user.get().getLikeCount();
//        return likeCount;
//    }
//
//    public Long getMvpCount(Long userId) {
//        Optional<User> user = userRepository.findById(userId);
//        Long MvpCount = user.get().getMvpCount();
//        return MvpCount;
//    }

    private Long getParticipationCount(User user) {
        return participantRepository.countByUser(user);
    }

    private List<PostDto> getPosts(User user) {
        List<Post> postList = postRepository.findAllByUser(user);
        List<PostDto> postDtoList = postList.stream()
                .map(PostDto::toDto)
                .collect(Collectors.toList());
        return postDtoList;
    }

    private List<PostDto> getParticipatedPosts(User user) {
        List<Participant> userParticipated = participantRepository.findAllByUser(user);
        List<Post> participatedPostList = userParticipated.stream()
                .map(Participant::getPost)
                .collect(Collectors.toList());
        List<PostDto> participatedPostDtoList = participatedPostList.stream()
                .map(PostDto::toDto)
                .collect(Collectors.toList());
        return participatedPostDtoList;
    }

}
