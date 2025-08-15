package org.AirlineManagement.service;


import lombok.RequiredArgsConstructor;
import org.AirlineManagement.DTO.PassengerDto;
import org.AirlineManagement.VO.CreatePassengerVo;
import org.AirlineManagement.classes.Passenger;
import org.AirlineManagement.classes.Plane;
import org.AirlineManagement.presentation.input.CreatePassengerDto;
import org.AirlineManagement.repository.PassengerRepository;
import org.AirlineManagement.repository.PlaneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;
    private final PlaneRepository planeRepository;

    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }
    public Passenger save(CreatePassengerVo vo) {
        Plane plane = planeRepository.findById(vo.planeId())
                .orElseThrow(() -> new IllegalArgumentException("Plane not found with id " + vo.planeId()));

        Passenger passenger = new Passenger();
        passenger.setFirstName(vo.firstName());
        passenger.setName(vo.name());
        passenger.setAge(vo.age());
        passenger.setEmail(vo.email());
        passenger.setPhone(vo.phone());
        passenger.setPlane(plane);
        return passengerRepository.save(passenger);
    }
    public Passenger updatePassenger(Long id, PassengerDto dto) {
        Passenger existing = passengerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Passenger not found with id " + id));

        existing.setFirstName(dto.firstName());
        existing.setName(dto.name());
        existing.setAge(dto.age());
        existing.setEmail(dto.email());
        existing.setPhone(dto.phone());

        return passengerRepository.save(existing);
    }

    public Passenger findById(Long id) {
        return passengerRepository.findById(id).orElse(null);
    }
    public void deleteById(Long id) {
        passengerRepository.deleteById(id);
    }
    public boolean existsById(Long id) {
        if(findById(id) == null) {
             return false;
         } else {
             return true;
         }
    }
}
