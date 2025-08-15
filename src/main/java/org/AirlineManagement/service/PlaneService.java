package org.AirlineManagement.service;

import lombok.RequiredArgsConstructor;
import org.AirlineManagement.VO.CreatePlaneVo;
import org.AirlineManagement.classes.Plane;
import org.AirlineManagement.mapper.PlaneMapper;
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
    public Plane save(CreatePlaneVo vo) {
       var plane = PlaneMapper.toPlane(vo);

        return planeRepository.save(plane);
    }
    public Plane findById(Long id) {
        return planeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Plane not found with id " + id));
    }
    public void deleteById(Long id) {
        planeRepository.deleteById(id);
    }

}
