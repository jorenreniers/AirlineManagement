package org.AirlineManagement.presentation.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CreatePassengerDto (
        String name,
        String firstName,
        int age,
        @Email String email,
        String phone,
        @NotNull Long planeId


){
}
