package com.negin.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@ApplicationScoped
@Entity(name = "CoordinateRepository")
public class Coordinate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String x;
    private String y;
    private String name;

    public Coordinate(String x, String y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }
}
