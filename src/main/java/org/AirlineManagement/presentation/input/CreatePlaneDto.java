package org.AirlineManagement.presentation.input;

public record CreatePlaneDto(
         String codeName,
         String model,
         Integer capacity,
         String type,
         Long registrationNumber,
         String manufacturer,
         String seatingCapacity,
         String fuelType,
         String engineType,
         String status
) {
}
