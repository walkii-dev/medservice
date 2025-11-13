package com.medical.medservice.domains.appointment;

import java.time.LocalDate;

public record AppointmentDetailsDTO(Long id,
                                    String medic,
                                    String patient,
                                    LocalDate appointmentDateAndHour,
                                    String weather,
                                    String observations,
                                    Status status) {

    public AppointmentDetailsDTO(Appointment appointment){
        this(appointment.getId(),
                appointment.getMedic(),
                appointment.getPatient(),
                appointment.getAppointmentDateAndHour(),
                appointment.getWeather(),
                appointment.getObservations(),
                appointment.getStatus());
    }
}
