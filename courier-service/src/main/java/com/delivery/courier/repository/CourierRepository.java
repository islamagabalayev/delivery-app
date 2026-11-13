package com.delivery.courier.repository;

import com.delivery.courier.entity.Courier;
import com.delivery.courier.enums.CourierStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {
    Optional<Courier> findFirstByCourierStatus(CourierStatus courierStatus);
}
