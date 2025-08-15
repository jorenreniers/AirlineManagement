package org.AirlineManagement.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.AirlineManagement.DTO.PlaneDto;
import org.AirlineManagement.mapper.PlaneMapper;
import org.AirlineManagement.service.PlaneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/planes")
public class PlaneController {

    private final PlaneService planeService;

    @GetMapping()
    public ResponseEntity<List<PlaneDto>> getAllPlanes(){
        var planes = planeService.findAll();
        var planedto= planes.stream().map(PlaneMapper::MapToPlaneDto).toList();
        return ResponseEntity.ok(planedto);
    }

}

