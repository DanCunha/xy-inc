package com.zup.TesteDev.service.impl;

import com.zup.TesteDev.domain.Poi;
import com.zup.TesteDev.dto.PoiDTO;
import com.zup.TesteDev.repository.PoiRepository;
import com.zup.TesteDev.service.PoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoiServiceImpl implements PoiService {

    @Autowired
    private PoiRepository poiRepository;

    @Override
    public List<Poi> findAll() {
       // List<PoiDTO> poiDTOList = poiRepository.findAll();
        return null;
    }

    @Override
    public Poi add(Poi entity) {
        return poiRepository.save(entity);
    }
}
