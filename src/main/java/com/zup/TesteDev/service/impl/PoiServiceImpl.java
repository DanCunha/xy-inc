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
    public List<PoiDTO> listPoisByProx(Integer cord_x, Integer cord_y, Integer d_max) {
        List<Poi> poiList = poiRepository.findAll();
        List<PoiDTO> poiDTOList = new ArrayList<>();

        for (Poi poi: poiList) {
            if(calculateProximity(poi.getCord_x(), poi.getCord_y(), cord_x, cord_y, d_max)){
                poiDTOList.add(new PoiMapper().getPoiDTO(poi));
            }
        }

        return poiDTOList;
    }

    public boolean calculateProximity(Integer cord_x, Integer cord_y, Integer req_cord_x, Integer req_cord_y, Integer d_max){
        Integer res_x = (req_cord_x - cord_x) * (req_cord_x - cord_x);
        Integer res_y = (req_cord_y - cord_y) * (req_cord_y - cord_y);
        return Math.sqrt(res_x + res_y) <= d_max ? true : false;
    }
}
