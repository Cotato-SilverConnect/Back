package com.cotato.silverconnect.service;

import com.cotato.silverconnect.domain.dto.PostResponseDto;
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
}
