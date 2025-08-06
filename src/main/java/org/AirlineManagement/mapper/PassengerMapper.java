package org.AirlineManagement.mapper;

import org.AirlineManagement.DTO.PassengerDto;
import org.AirlineManagement.classes.Passenger;

public abstract class PassengerMapper {

    public static Passenger MapToPassenger(PassengerDto passengerDto) {
        return Passenger.builder()
                .id(passengerDto.id())
                .firstName(passengerDto.firstName())
                .name(passengerDto.name())
                .age(passengerDto.age())
                .email(passengerDto.email())
                .phone(passengerDto.phone())
                .build();
    }

    public static PassengerDto MapToPassengerDto(Passenger passenger){
        return PassengerDto.builder()
                .id(passenger.getId())
                .firstName(passenger.getFirstName())
                .name(passenger.getName())
                .age(passenger.getAge())
                .email(passenger.getEmail())
                .phone(passenger.getPhone())
                .build();
    }
}
