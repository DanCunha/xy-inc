package com.zup.TesteDev.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
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
    @Column(unique = true)
    private String name;
    @Min(1)
    private Integer cord_x;
    @Min(1)
    private Integer cord_y;
}
