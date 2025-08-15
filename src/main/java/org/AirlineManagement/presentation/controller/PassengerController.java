package org.AirlineManagement.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.AirlineManagement.DTO.PassengerDto;
import org.AirlineManagement.classes.Passenger;
import org.AirlineManagement.mapper.PassengerMapper;
import org.AirlineManagement.presentation.input.CreatePassengerDto;
import org.AirlineManagement.service.PassengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/passengers")
@CrossOrigin(origins = "http://localhost:3000")
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
    public ResponseEntity<PassengerDto> createPassenger( @RequestBody CreatePassengerDto createPassengerDto) {
        var passenger = PassengerMapper.MapToCreatePassengerVo(createPassengerDto);

        Passenger savedPassenger = passengerService.save(passenger);

        PassengerDto passengerDto = PassengerMapper.MapToPassengerDto(savedPassenger);

        return ResponseEntity.ok(passengerDto);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<PassengerDto> updatePassenger(@PathVariable Long id, @RequestBody PassengerDto passengerDto) {
        try {
            var savedPassenger = passengerService.updatePassenger(id, passengerDto);
            return ResponseEntity.ok(PassengerMapper.MapToPassengerDto(savedPassenger));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().build();
        }
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
