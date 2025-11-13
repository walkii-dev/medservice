package com.medical.medservice.repositories;

import com.medical.medservice.domains.appointment.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Page<Appointment> findAll(Pageable pageable);

    @Query("select a from Appointment a where a.appointmentDateAndHour = ?1")
    Optional<Appointment> existsByAppointmentDateAndHour(LocalDate appointmentDate);
}
