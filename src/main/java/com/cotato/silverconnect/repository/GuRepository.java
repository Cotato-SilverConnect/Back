package com.cotato.silverconnect.repository;

import com.cotato.silverconnect.domain.entity.Gu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuRepository extends JpaRepository<Gu, Long> {
    public Optional<Gu> findByName(String name);
    public boolean existsByName(String name);
}
