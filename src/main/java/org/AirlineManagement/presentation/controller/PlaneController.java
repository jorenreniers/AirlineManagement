package org.AirlineManagement.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.AirlineManagement.DTO.PlaneDto;
import org.AirlineManagement.classes.Plane;
import org.AirlineManagement.mapper.PlaneMapper;
import org.AirlineManagement.presentation.input.CreatePlaneDto;
import org.AirlineManagement.service.PlaneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/planes")
@CrossOrigin(origins = "http://localhost:3000")

public class PlaneController {

    private final PlaneService planeService;

    @GetMapping()
    public ResponseEntity<List<PlaneDto>> getAllPlanes(){
        var planes = planeService.findAll();
        var planedto= planes.stream().map(PlaneMapper::MapToPlaneDto).toList();
        return ResponseEntity.ok(planedto);
    }

    @PostMapping
    public ResponseEntity<PlaneDto> createPlane(@RequestBody CreatePlaneDto createPlaneDto){
        var plane = PlaneMapper.MapToCreatePlaneVo(createPlaneDto);
        Plane savedPlane= planeService.save(plane);
        PlaneDto planeDto = PlaneMapper.MapToPlaneDto(savedPlane);
        return ResponseEntity.ok(planeDto);
    }

}

