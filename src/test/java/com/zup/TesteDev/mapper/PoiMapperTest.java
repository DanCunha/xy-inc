package com.zup.TesteDev.mapper;

import com.zup.TesteDev.domain.Poi;
import com.zup.TesteDev.dto.PoiDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PoiMapperTest {

    @Test
    void getPoiEntity(){
        PoiDTO dto = new PoiDTO((long)1,"Lanchonete", 27, 12);
        Poi entity = new PoiMapper().getPoiEntity(dto);
        checkProperties(dto, entity);
    }

    private void checkProperties(PoiDTO dto, Poi entity) {
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getName(), entity.getName());
        assertEquals(dto.getCord_x(), entity.getCord_x());
        assertEquals(dto.getCord_y(), entity.getCord_y());
    }
}
