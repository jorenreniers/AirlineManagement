package org.AirlineManagement.classes;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="plane")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codeName;
    private String model;
    private Integer capacity;
    private String type;
    private Long registrationNumber;
    private String manufacturer;
    private String seatingCapacity;
    private String fuelType;
    private String engineType;
    private String status;

    @OneToMany(mappedBy = "plane", fetch = FetchType.EAGER)
    private Set<Passenger> passengers = new HashSet<>();
}
