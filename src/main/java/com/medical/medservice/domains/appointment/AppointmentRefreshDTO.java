package com.medical.medservice.domains.appointment;

import java.time.LocalDate;

public record AppointmentRefreshDTO(Long id,
                                    String medic,
                                    LocalDate appointmentDateAndHour,
                                    String observations) {
}
