package org.AirlineManagement.mapper;

import org.AirlineManagement.DTO.PassengerDto;
import org.AirlineManagement.VO.CreatePassengerVo;
import org.AirlineManagement.classes.Passenger;
import org.AirlineManagement.classes.Plane;
import org.AirlineManagement.presentation.input.CreatePassengerDto;

public abstract class PassengerMapper {

    public static Passenger MapToPassenger(PassengerDto passengerDto) {
        return Passenger.builder()
                .id(passengerDto.id())
                .firstName(passengerDto.firstName())
                .name(passengerDto.name())
                .age(passengerDto.age())
                .email(passengerDto.email())
                .phone(passengerDto.phone())
                .plane(Plane.builder().id(passengerDto.planeId()).build())
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
                .planeId(passenger.getPlane() != null ? passenger.getPlane().getId() : null)
                .build();
    }
    public static Passenger ToPassenger(CreatePassengerDto dto) {
        Passenger passenger = new Passenger();
        passenger.setFirstName(dto.firstName());
        passenger.setName(dto.name());
        passenger.setAge(dto.age());
        passenger.setEmail(dto.email());
        passenger.setPhone(dto.phone());
        Plane planeRef = new Plane();
        planeRef.setId(dto.planeId());
        passenger.setPlane(planeRef);


        return passenger;
    }

    public static CreatePassengerVo MapToCreatePassengerVo(CreatePassengerDto createPassengerDto) {
        return CreatePassengerVo.builder()
                .firstName(createPassengerDto.firstName())
                .name(createPassengerDto.name())
                .age(createPassengerDto.age())
                .email(createPassengerDto.email())
                .phone(createPassengerDto.phone())
                .planeId(createPassengerDto.planeId())
                .build();
    }

    public static Passenger toPassenger(CreatePassengerVo vo) {
        return Passenger.builder()
                .firstName(vo.firstName())
                .name(vo.name())
                .age(vo.age())
                .email(vo.email())
                .phone(vo.phone())
                .plane(Plane.builder().id(vo.planeId()).build())
                .build();
    }
}
