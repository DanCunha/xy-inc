package com.zup.TesteDev.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PoiDTO {

    private Long id;
    private String name;
    private Integer cord_x;
    private Integer cord_y;

}
