package com.medical.medservice.domain.appointment;

public record AppointmentCreationDTO(String medic,
                                     String patient,
                                     String appointmentDateAndHour,
                                     String weather,
                                     String observations) {
}
