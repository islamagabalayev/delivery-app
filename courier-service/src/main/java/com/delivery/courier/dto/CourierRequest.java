package com.delivery.courier.dto;

import com.delivery.courier.enums.CourierStatus;
import com.delivery.courier.enums.CourierVehicleType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourierRequest {

    private String name;
    private String surname;
    private String phoneNumber;
    private String city;
    private CourierVehicleType courierVehicleType;
}