package org.AirlineManagement.mapper;

import org.AirlineManagement.DTO.PassengerDto;
import org.AirlineManagement.DTO.PlaneDto;
import org.AirlineManagement.classes.Passenger;
import org.AirlineManagement.classes.Plane;

public class PlaneMapper {

    public static Plane MapToPassenger(PlaneDto planeDto) {
        return Plane.builder()
                .id(planeDto.id())
                .codeName(planeDto.codeName())
                .model(planeDto.model())
                .capacity(planeDto.capacity())
                .type(planeDto.type())
                .registrationNumber(planeDto.registrationNumber())
                .manufacturer(planeDto.manufacturer())
                .seatingCapacity(planeDto.seatingCapacity())
                .fuelType(planeDto.fuelType())
                .engineType(planeDto.engineType())
                .status(planeDto.status())
                .build();

    }

    public static PlaneDto MapToPlaneDto(Plane plane){
        return PlaneDto.builder()
                .id(plane.getId())
                .codeName(plane.getCodeName())
                .model(plane.getModel())
                .capacity(plane.getCapacity())
                .type(plane.getType())
                .registrationNumber(plane.getRegistrationNumber())
                .manufacturer(plane.getManufacturer())
                .seatingCapacity(plane.getSeatingCapacity())
                .fuelType(plane.getFuelType())
                .engineType(plane.getEngineType())
                .status(plane.getStatus())
                .build();
    }


}
