package org.AirlineManagement.VO;

import lombok.Builder;

@Builder
public record CreatePlaneVo (
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
){
}
