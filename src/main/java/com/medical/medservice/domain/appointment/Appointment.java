package com.medical.medservice.domain.appointment;

import jakarta.persistence.*;
import lombok.*;

@Entity
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
}