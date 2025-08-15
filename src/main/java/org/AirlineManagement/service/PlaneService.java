package org.AirlineManagement.service;

import lombok.RequiredArgsConstructor;
import org.AirlineManagement.classes.Plane;
import org.AirlineManagement.repository.PlaneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlaneService {
    private final PlaneRepository planeRepository;
    public List<Plane> findAll() {
        return planeRepository.findAll();
    }

}
