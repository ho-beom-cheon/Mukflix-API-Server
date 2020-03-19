package com.mukflix.backend.apiserver.dao.repository;

import com.mukflix.backend.apiserver.dto.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideRepository extends JpaRepository<Guide, String> {

    @Override
    void deleteById(String s);

}
