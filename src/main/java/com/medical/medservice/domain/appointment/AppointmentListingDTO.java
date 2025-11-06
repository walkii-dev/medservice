package com.medical.medservice.domain.appointment;

public record AppointmentListingDTO(Long id,
                                    String medic,
                                    String patient,
                                    String appointmentDateAndHour) {
    public AppointmentListingDTO (Appointment appointment){
        this(appointment.getId(),
                appointment.getMedic(),
                appointment.getPatient(),
                appointment.getAppointmentDateAndHour());
    }
}
