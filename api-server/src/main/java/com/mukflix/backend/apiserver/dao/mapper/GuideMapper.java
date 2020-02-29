package com.mukflix.backend.apiserver.dao.mapper;

import com.mukflix.backend.apiserver.dto.Guide;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
public interface GuideMapper {

    List<Guide> getGuideList();
}