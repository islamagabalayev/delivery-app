package com.delivery.courier.dto;

import com.delivery.courier.enums.CourierStatus;
import com.delivery.courier.enums.CourierVehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourierResponse {

    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String city;
    private CourierVehicleType courierVehicleType;
    private CourierStatus courierStatus;
}