package com.zup.TesteDev.controller;

import com.zup.TesteDev.dto.PoiDTO;
import com.zup.TesteDev.mapper.PoiMapper;
import com.zup.TesteDev.service.PoiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Api(value = "Poi Controller")
@RestController()
@RequestMapping(value = "/poi")
@CrossOrigin
public class PoiController {

    @Autowired
    private PoiService poiService;

    @PostMapping
    @ApiOperation(value = "Create Poi")
    public PoiDTO create(@RequestBody @Valid PoiDTO dto){
        return new PoiMapper().getPoiDTO(poiService.add(new PoiMapper().getPoiEntity(dto)));
    }

    @GetMapping
    @ApiOperation(value = "Find All Pois")
    public List<PoiDTO> findAll(){
        return poiService.findAll();
    }

    @GetMapping("/listPoisByProx")
    @ApiOperation(value = "List Pois by proximity")
    public List<PoiDTO> listPoisByProx(@RequestParam(value = "cord_x",required = true) Integer cord_x,
                                          @RequestParam(value = "cord_y",required = true) Integer cord_y,
                                            @RequestParam(value = "d_max",required = true) Integer d_max){
        return poiService.listPoisByProx(cord_x, cord_y, d_max);
    }

}
