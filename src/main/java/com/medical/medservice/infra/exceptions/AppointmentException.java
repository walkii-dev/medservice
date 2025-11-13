package com.medical.medservice.infra.exceptions;

public class AppointmentException extends RuntimeException {
    public AppointmentException(String message) {
        super(message);
    }
}
