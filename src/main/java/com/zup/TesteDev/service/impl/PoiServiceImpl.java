package com.zup.TesteDev.service.impl;

import com.zup.TesteDev.domain.Poi;
import com.zup.TesteDev.dto.PoiDTO;
import com.zup.TesteDev.mapper.PoiMapper;
import com.zup.TesteDev.repository.PoiRepository;
import com.zup.TesteDev.service.PoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PoiServiceImpl implements PoiService {

    @Autowired
    private PoiRepository poiRepository;

    @Override
    public List<PoiDTO> findAll() {
        List<Poi> poiList = poiRepository.findAll();
        return new PoiMapper().getListPoiDTO(poiList);
    }

    @Override
    public Poi add(Poi entity) {
        return poiRepository.save(entity);
    }

    @Override
    public List<PoiDTO> listarPoisPorProx(Integer cord_x, Integer cord_y, Integer d_max) {
        List<Poi> poiList = poiRepository.findAll();
        List<PoiDTO> poiDTOList = new ArrayList<>();

        for (Poi poi: poiList) {
            if((((poi.getCord_x() - cord_x) * -1) <= d_max) && (((poi.getCord_y() - cord_y) * -1) <= d_max)){
                System.out.println("Cordenada 1: " + ((poi.getCord_x() - cord_x)) );
                System.out.println("Cordenada 2: " + ((poi.getCord_y() - cord_y)) );
                poiDTOList.add(new PoiMapper().getPoiDTO(poi));
            }

        }

        return poiDTOList;
    }
}
