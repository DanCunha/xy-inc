package com.zup.TesteDev.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Poi")
public class Poi implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "poi_id", nullable = false)
    private Long id;
    private String name;
    private Integer cord_x;
    private Integer cord_y;
}
