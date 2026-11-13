package com.delivery.courier.entity;

import com.delivery.courier.enums.CourierStatus;
import com.delivery.courier.enums.CourierVehicleType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String city;
    private Double rating;
    @Enumerated(EnumType.STRING)
    private CourierStatus courierStatus;
    @Enumerated(EnumType.STRING)
    private CourierVehicleType courierVehicleType;

}
