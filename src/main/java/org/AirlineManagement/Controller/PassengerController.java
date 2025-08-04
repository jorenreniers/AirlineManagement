package org.AirlineManagement.Controller;

import org.AirlineManagement.Classes.Passenger;
import org.AirlineManagement.Repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerController(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    // ✅ GET all passengers
    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    // ✅ GET passenger by ID
    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long id) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(id);
        return optionalPassenger
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ POST (create) a new passenger
    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    // ✅ PUT (update) passenger
    @PutMapping("/{id}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable Long id, @RequestBody Passenger updatedPassenger) {
        return passengerRepository.findById(id)
                .map(passenger -> {
                    passenger.setName(updatedPassenger.getName());
                    passenger.setFirstName(updatedPassenger.getFirstName());
                    passenger.setEmail(updatedPassenger.getEmail());
                    passenger.setPhone(updatedPassenger.getPhone());
                    passenger.setAge(updatedPassenger.getAge());
                    return ResponseEntity.ok(passengerRepository.save(passenger));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ DELETE passenger
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id) {
        if (passengerRepository.existsById(id)) {
            passengerRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
