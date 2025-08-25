package org.AirlineManagement.DTO;

import lombok.Builder;

@Builder
public record PassengerDto(
        Long id,
        String firstName,
        String name,
        int age,
        String email,
        String phone,
        Long planeId
) {

}
