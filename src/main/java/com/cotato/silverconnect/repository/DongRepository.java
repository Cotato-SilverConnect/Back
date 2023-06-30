package com.cotato.silverconnect.repository;

import com.cotato.silverconnect.domain.entity.Dong;
import com.cotato.silverconnect.domain.entity.Gu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DongRepository extends JpaRepository<Dong, Long> {
    public Optional<Dong> findByName(String name);

    public List<Dong> findAllByGu(Gu gu);

    public boolean existsByNameAndGu(String name, Gu gu);
}
