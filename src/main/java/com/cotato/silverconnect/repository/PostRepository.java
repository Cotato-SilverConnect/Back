package com.cotato.silverconnect.repository;

import com.cotato.silverconnect.domain.entity.Dong;
import com.cotato.silverconnect.domain.entity.Gu;
import com.cotato.silverconnect.domain.entity.Post;
import com.cotato.silverconnect.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostsByCategory(String category);
    List<Post> findAllByUser(User user);
    List<Post> findByCategoryContainsAndGu_Name(String category, String gu);
    List<Post> findByCategoryContainsAndDong_Name(String category, String dong);
}
