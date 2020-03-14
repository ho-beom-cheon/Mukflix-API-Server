package com.mukflix.backend.apiserver.dao.repository;

import com.mukflix.backend.apiserver.dto.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedRepository extends JpaRepository<Feed, String> {
}
