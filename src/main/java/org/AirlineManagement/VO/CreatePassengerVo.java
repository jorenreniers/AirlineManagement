package org.AirlineManagement.VO;

import lombok.Builder;

@Builder
public record CreatePassengerVo (
        String name,
        String firstName,
        int age,
        String email,
        String phone,
        Long planeId


){
}
