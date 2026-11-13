package com.delivery.courier.service;

import com.delivery.courier.dto.CourierRequest;
import com.delivery.courier.dto.CourierResponse;
import com.delivery.courier.entity.Courier;
import com.delivery.courier.enums.CourierStatus;
import com.delivery.courier.exception.CourierNotFoundException;
import com.delivery.courier.exception.NoAvailableCourierException;
import com.delivery.courier.repository.CourierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourierService {

    private final CourierRepository courierRepository;

    @Transactional
    public CourierResponse create(CourierRequest request) {
        Courier courier = Courier.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .phoneNumber(request.getPhoneNumber())
                .city(request.getCity())
                .courierVehicleType(request.getCourierVehicleType())
                .courierStatus(CourierStatus.FREE)
                .build();
        return toResponse(courierRepository.save(courier));
    }

    public List<CourierResponse> getAll() {
        return courierRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public CourierResponse getById(Long id) {
        return toResponse(findOrThrow(id));
    }

    public CourierResponse getAvailable() {
        Courier courier = courierRepository.findFirstByCourierStatus(CourierStatus.FREE)
                .orElseThrow(() -> new NoAvailableCourierException("No Available courier"));
        return toResponse(courier);
    }

    @Transactional
    public CourierResponse updateStatus(Long id, CourierStatus status) {
    Courier courier = findOrThrow(id);
    courier.setCourierStatus(status);
    return toResponse(courierRepository.save(courier));
    }

    private Courier findOrThrow(Long id) {
        return courierRepository.findById(id)
                .orElseThrow(()-> new CourierNotFoundException("Courier not found with id: " +id));

    }

    private CourierResponse toResponse(Courier courier) {
        return new CourierResponse(
                courier.getId(),
                courier.getName(),
                courier.getSurname(),
                courier.getPhoneNumber(),
                courier.getCity(),
                courier.getCourierVehicleType(),
                courier.getCourierStatus()
        );
    }
}
