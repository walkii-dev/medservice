package com.medical.medservice.domain.appointment;

public record AppointmentDetailsDTO(Long id,
                                    String medic,
                                    String patient,
                                    String appointmentDateAndHour,
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
