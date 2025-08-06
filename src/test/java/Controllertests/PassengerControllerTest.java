package Controllertests;


import org.AirlineManagement.DTO.PassengerDto;
import org.AirlineManagement.classes.Passenger;
import org.AirlineManagement.controller.PassengerController;
import org.AirlineManagement.service.PassengerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.Assertions;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PassengerControllerTest {

    @Mock
    private PassengerService passengerService;

    @InjectMocks
    private PassengerController passengerController;

    //Test Passenger
    Passenger passenger = Passenger.builder()
            .id(1L)
            .firstName("John")
            .name("Doe")
            .age(25)
            .email("johnDoe@email.com")
            .phone("1234567890")
            .build();

    List<Passenger> mockList = List.of(passenger);

    @Test
    void getAllPassengersTest() {
        when(passengerService.findAll()).thenReturn(mockList);

        ResponseEntity<List<PassengerDto>> response = passengerController.getAllPassengers();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());

        PassengerDto passengerDto = response.getBody().get(0);
        assertEquals(passenger.getId(), passengerDto.id());
    }

}
