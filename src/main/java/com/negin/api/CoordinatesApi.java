package com.negin.api;


import com.negin.entity.Coordinate;
import com.negin.repository.CoordinateRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/map")
public class CoordinatesApi {
    @Inject
    CoordinateRepository coordinateRepository;

    @GET
    @Path("/coordinates")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Coordinate> getCoordinates() {
        return coordinateRepository.listAll();
    }
}
