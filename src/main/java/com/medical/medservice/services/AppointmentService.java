package com.medical.medservice.services;

import com.medical.medservice.domains.appointment.Appointment;
import com.medical.medservice.domains.appointment.AppointmentListingDTO;
import com.medical.medservice.infra.exceptions.AppointmentException;
import com.medical.medservice.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    public Appointment checkDisponibility (Appointment appointment){
        Optional<Appointment> search = repository.existsByAppointmentDateAndHour(appointment.getAppointmentDateAndHour());
        if (search.isPresent()){
            throw new AppointmentException("já existe uma consulta nesta mesma data");
        }
        return search.get();
    }

    public Page<AppointmentListingDTO> listAppointments (Pageable pageable){
        Page<Appointment> appointmentsPage = repository.findAll(pageable);
        return appointmentsPage.map(AppointmentListingDTO::new);
    }
}
