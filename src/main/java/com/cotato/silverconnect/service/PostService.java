package com.cotato.silverconnect.service;

import com.cotato.silverconnect.domain.dto.PostListResponseDto;
import com.cotato.silverconnect.domain.dto.PostResponseDto;
import com.cotato.silverconnect.domain.entity.Dong;
import com.cotato.silverconnect.domain.entity.Gu;
import com.cotato.silverconnect.domain.entity.Participant;
import com.cotato.silverconnect.domain.entity.Post;
import com.cotato.silverconnect.repository.ParticipantRepository;
import com.cotato.silverconnect.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final ParticipantRepository participantRepository;
    public PostResponseDto getPost(Long id){
        Post post = postRepository.findById(id).get();
        Long currentPartricipantNum = participantRepository.countByPost(post);
        List<Participant> participantList = participantRepository.findAllByPost(post);
        List<String> participants = participantList.stream()
                .map(participant -> {
                    return participant.getUser().getUsername();
                })
                .collect(Collectors.toList());

        return PostResponseDto.toDto(post,
                post.getGu().getName(),
                post.getDong().getName(),
                currentPartricipantNum < post.getLimitParticipantNum(),
                currentPartricipantNum,
                participants
                );

    }

    public List<PostListResponseDto> getPostList(String category, String gu, String dong) {
        List<Post> post;

        if (dong == null) {
            post = postRepository.findByCategoryContainsAndGu_Name(category, gu);
        } else {
            post = postRepository.findByCategoryContainsAndDong_Name(category, dong);
        }

        List<PostListResponseDto> postList = post.stream()
                .map(postElement->{
                    Long currentPartricipantNum = participantRepository.countByPost(postElement);
                    return PostListResponseDto.toDto(postElement,
                            currentPartricipantNum,
                            currentPartricipantNum < postElement.getLimitParticipantNum()
                            );
                })
                .collect(Collectors.toList());

        return postList;

    }
}
