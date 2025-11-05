package com.medical.medservice.domain.appointment;

public record AppointmentListingDTO(Long id,
                                    String medic,
                                    String patient,
                                    String appointmentDateAndHour) {
}
