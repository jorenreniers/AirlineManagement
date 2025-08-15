package org.AirlineManagement.presentation.input;

public record CreatePassengerDto (
        String name,
        String firstName,
        int age,
        String email,
        String phone,
        Long planeId


){
}
