package com.medical.medservice.domains.appointment;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AppointmentCreationDTO(@NotNull(message = "Medic is necessary")
                                     String medic,
                                     @NotNull(message = "Patient is necessary")
                                     String patient,
                                     @NotNull(message = "tem que ter uma data")
                                     LocalDate appointmentDateAndHour,
                                     String weather,
                                     String observations) {
}
