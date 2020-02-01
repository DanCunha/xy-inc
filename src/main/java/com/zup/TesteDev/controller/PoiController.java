package com.zup.TesteDev.controller;

import com.zup.TesteDev.dto.PoiDTO;
import com.zup.TesteDev.mapper.PoiMapper;
import com.zup.TesteDev.service.PoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController()
@RequestMapping("/poi")
@CrossOrigin
public class PoiController {

    @Autowired
    private PoiService poiService;

    @PostMapping
    public PoiDTO create(@RequestBody @Valid PoiDTO dto){
        return new PoiMapper().getPoiDTO(poiService.add(new PoiMapper().getPoiEntity(dto)));
    }

}
