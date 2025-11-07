package com.medical.medservice.domain.appointment;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Appointment")
@Table(name = "consultas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medic;
    private String patient;
    private String appointmentDateAndHour;
    private String weather;
    private String observations;
    private Status status;

    public Appointment(AppointmentCreationDTO data){
        this.medic = data.medic();
        this.patient = data.patient();
        this.appointmentDateAndHour = data.appointmentDateAndHour();
        this.weather = data.weather();
        this.observations = data.observations();
        this.status = Status.CREATED;
    }

    public void updateAppointment(AppointmentRefreshDTO refreshData){
        this.medic = refreshData.medic();
        this.appointmentDateAndHour = refreshData.appointmentDateAndHour();
        this.observations = refreshData.observations();
        this.status = Status.UPDATED;
    }

    public void cancel(){
        this.status = Status.CANCELLED;
    }
}