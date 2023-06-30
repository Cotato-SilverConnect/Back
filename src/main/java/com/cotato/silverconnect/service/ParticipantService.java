package com.cotato.silverconnect.service;

import com.cotato.silverconnect.domain.dto.ParticipantDto;
import com.cotato.silverconnect.domain.dto.PostDto;
import com.cotato.silverconnect.domain.entity.Participant;
import com.cotato.silverconnect.domain.entity.Post;
import com.cotato.silverconnect.domain.entity.User;
import com.cotato.silverconnect.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParticipantService {
    private final ParticipantRepository participantRepository;
//
//    private List<PostDto> getPosts(User user) {
//        List<Participant> postList = participantRepository.findAllByUser(user);
//        return postList.stream()
//                .map(PostDto::toDto)
//                .collect(Collectors.toList());
//    }
//    @Transactional
//    public Long getParticipationCount(User user) {
//        return participantRepository.countByUser(user);
//    }
}
