package com.delivery.courier.exception;

public class NoAvailableCourierException extends RuntimeException{

    public NoAvailableCourierException(String message) {
        super(message);
    }
}
