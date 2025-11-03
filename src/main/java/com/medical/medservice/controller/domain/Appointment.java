package com.medical.medservice.controller.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    private Doctor doctor;
    private Patient patient;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private Weather weather;
    private String obtservations;
}
