package com.medical.medservice.domains.medic;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "medicos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
public class Medic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    private Speciality speciality;

    //private User user;

    //private List<Appointment> Appointments;


}
