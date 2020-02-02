package com.zup.TesteDev.controller;

import com.zup.TesteDev.dto.PoiDTO;
import com.zup.TesteDev.mapper.PoiMapper;
import com.zup.TesteDev.service.PoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

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

    @GetMapping
    public List<PoiDTO> findAll(){
        return poiService.findAll();
    }

    @GetMapping("/listPoisByProx")
    public List<PoiDTO> listarPoisByProx(@RequestParam(value = "cord_x",required = true) @Min(1) Integer cord_x,
                                          @RequestParam(value = "cord_y",required = true) @Min(1) Integer cord_y,
                                            @RequestParam(value = "d_max",required = true) @Min(1) Integer d_max){
        return poiService.listPoisByProx(cord_x, cord_y, d_max);
    }

}
