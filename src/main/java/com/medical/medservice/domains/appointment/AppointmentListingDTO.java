package com.medical.medservice.domains.appointment;

import java.time.LocalDate;

public record AppointmentListingDTO(Long id,
                                    String medic,
                                    String patient,
                                    LocalDate appointmentDateAndHour) {
    public AppointmentListingDTO (Appointment appointment){
        this(appointment.getId(),
                appointment.getMedic(),
                appointment.getPatient(),
                appointment.getAppointmentDateAndHour());
    }
}
