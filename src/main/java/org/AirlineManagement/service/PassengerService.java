package org.AirlineManagement.service;


import lombok.RequiredArgsConstructor;
import org.AirlineManagement.classes.Passenger;
import org.AirlineManagement.repository.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }
    public Passenger save(Passenger passenger) {
        return passengerRepository.save(passenger);
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
