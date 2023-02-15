package com.negin.repository;

import com.negin.entity.Coordinate;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class CoordinateRepository implements PanacheRepository<Coordinate> {
}

