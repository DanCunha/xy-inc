package com.zup.TesteDev.mapper;

import com.zup.TesteDev.domain.Poi;
import com.zup.TesteDev.dto.PoiDTO;

import java.util.ArrayList;
import java.util.List;

public class PoiMapper {

    public Poi getPoiEntity(PoiDTO dto){
        return Poi.builder()
                .id(dto.getId())
                .name(dto.getName())
                .cord_x(dto.getCord_x())
                .cord_y(dto.getCord_y())
                .build();
    }

    public PoiDTO getPoiDTO(Poi entity){
        return PoiDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .cord_x(entity.getCord_x())
                .cord_y(entity.getCord_y())
                .build();
    }

    public List<PoiDTO> getListPoiDTO(List<Poi> pois){
        List<PoiDTO> poiDTOList = new ArrayList<>();

        for (Poi poi : pois) {
            poiDTOList.add(getPoiDTO(poi));
        }
        return poiDTOList;
    }

}
