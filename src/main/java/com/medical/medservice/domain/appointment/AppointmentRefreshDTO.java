package com.medical.medservice.domain.appointment;

public record AppointmentRefreshDTO(Long id,
                                    String medic,
                                    String appointmentDateAndHour,
                                    String observations) {
}
