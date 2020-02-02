package com.zup.TesteDev.service;

import com.zup.TesteDev.domain.Poi;
import com.zup.TesteDev.dto.PoiDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PoiService {

    List<PoiDTO> findAll();
    Poi add(Poi dto);
    List<PoiDTO> listPoisByProx(Integer cord_x, Integer cord_y, Integer d_max);

}
