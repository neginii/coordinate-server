package com.negin.service;


import com.negin.entity.Coordinate;
import com.negin.repository.CoordinateRepository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class DatabaseInitiatorService {

    @Inject
    CoordinateRepository coordinateRepository;

    @Transactional
    void initiateCoordinates(@Observes StartupEvent ev) {
        List<Coordinate> coordinates = List.of(
                new Coordinate("400", "-355", "ST-1003"),
                new Coordinate("175", "201", "ST-1009"),
                new Coordinate("158", "902", "ST-1003"),
                new Coordinate("-238", "-497", "STÖ-671"),
                new Coordinate("719", "1313", "ST-1306"),
                new Coordinate("-95", "662", "ST-838"),
                new Coordinate("553", "663", "ST-1341"),
                new Coordinate("2", "931", "ST-1331")
        );

        coordinateRepository.persist(coordinates);
    }
}
