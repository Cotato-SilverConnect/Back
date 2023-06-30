package com.cotato.silverconnect.repository;

import com.cotato.silverconnect.domain.entity.Participant;
import com.cotato.silverconnect.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Long countByUser(User user);
    List<Participant> findAllByUser(User user);
}
