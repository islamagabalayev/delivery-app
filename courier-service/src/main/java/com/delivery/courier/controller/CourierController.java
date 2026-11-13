package com.delivery.courier.controller;

import com.delivery.courier.dto.CourierRequest;
import com.delivery.courier.dto.CourierResponse;
import com.delivery.courier.dto.UpdateStatusRequest;
import com.delivery.courier.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courier")
@RequiredArgsConstructor
public class CourierController {

    private final CourierService courierService;

    @GetMapping
    public List<CourierResponse> getAll() {
        return courierService.getAll();
    }

    @GetMapping("/{id}")
    public CourierResponse getById(@PathVariable Long id) {
        return courierService.getById(id);
    }

    @GetMapping("/available")
    public CourierResponse getAvailable() {
        return courierService.getAvailable();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourierResponse create(@RequestBody CourierRequest request) {
        return courierService.create(request);
    }

    @PatchMapping("/{id}/status")
    public CourierResponse updateStatus(@PathVariable Long id, @RequestBody UpdateStatusRequest request) {
        return courierService.updateStatus(id, request.getStatus());
    }
}