package org.AirlineManagement.DTO;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import org.AirlineManagement.classes.Passenger;

import java.util.HashSet;
import java.util.Set;

@Builder
public record PlaneDto(
         Long id,
         String codeName,
         String model,
         Integer capacity,
         String type,
         Long registrationNumber,
         String manufacturer,
         String seatingCapacity,
         String fuelType,
         String engineType,
         String passengerCapacity,
         String status,
         Set<Passenger> passengers

) {
}
