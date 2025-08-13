package org.AirlineManagement.controller;

import lombok.RequiredArgsConstructor;
import org.AirlineManagement.DTO.PassengerDto;
import org.AirlineManagement.classes.Passenger;
import org.AirlineManagement.mapper.PassengerMapper;
import org.AirlineManagement.service.PassengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    private final PassengerService passengerService;



    @GetMapping
    public ResponseEntity<List<PassengerDto>>getAllPassengers() {
       var passengers = passengerService.findAll();
       var passengerDtos = passengers.stream().map(PassengerMapper::MapToPassengerDto).collect(Collectors.toList());
       return ResponseEntity.ok(passengerDtos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PassengerDto> getPassengerById(@PathVariable Long id) {
        return Optional.ofNullable(passengerService.findById(id))
                .map(PassengerMapper::MapToPassengerDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<PassengerDto> createPassenger(@RequestBody PassengerDto passengerDto) {
        var passenger = PassengerMapper.MapToPassenger(passengerDto);
        var savedPassenger = passengerService.save(passenger);
        return ResponseEntity.ok(PassengerMapper.MapToPassengerDto(savedPassenger));
    }


    @PatchMapping("/{id}")
    public ResponseEntity<PassengerDto> updatePassenger(@PathVariable Long id,@RequestBody PassengerDto passengerDto) {
        var existingPassenger = passengerService.findById(id);
        if (existingPassenger == null) {
            return ResponseEntity.notFound().build();
        }

        var updatedPassenger = PassengerMapper.MapToPassenger(passengerDto);
        updatedPassenger.setId(id);
        var savedPassenger = passengerService.save(updatedPassenger);

        return ResponseEntity.ok(PassengerMapper.MapToPassengerDto(savedPassenger));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id) {
        if (passengerService.existsById(id)) {
            passengerService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
