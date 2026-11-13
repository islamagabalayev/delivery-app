package com.delivery.courier.exception;

public class CourierNotFoundException extends RuntimeException{

    public CourierNotFoundException(String message) {
        super(message);
    }
}
