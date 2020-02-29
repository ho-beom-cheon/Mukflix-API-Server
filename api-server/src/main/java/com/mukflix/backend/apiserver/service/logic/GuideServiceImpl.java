package com.mukflix.backend.apiserver.service.logic;

import com.mukflix.backend.apiserver.dao.repository.GuideRepository;
import com.mukflix.backend.apiserver.dto.Guide;
import com.mukflix.backend.apiserver.service.GuideService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GuideServiceImpl implements GuideService {

    @Autowired
    GuideRepository guideRepository;

    @Override
    public List<Guide> getGuideList() {
        return guideRepository.findAll();
    }

    @Override
    public Guide createGuide(Guide guide) {
        log.info("serviceImpl" + guide.toString());
        return guideRepository.save(guide);
    }

    @Override
    public Guide updateGuideName(String id, String name) {
        Guide guide = guideRepository.findById(id).orElse(null);

        if (guide == null) {
            return null;
        }

        guide.setName(name);

        return guideRepository.save(guide);
    }

    @Override
    public Boolean deleteGuide(String id) {
        Guide guide = guideRepository.findById(id).orElse(null);

        if (guide == null) {
            return null;
        }

        guideRepository.deleteById(id);

        return null;
    }
}
