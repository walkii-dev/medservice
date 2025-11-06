package com.medical.medservice.domain.appointment;

import com.medical.medservice.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired

    private AppointmentRepository repository;

    public Page<AppointmentListingDTO> listAppointments (Pageable pageable){
        Page<Appointment> appointmentsPage = repository.findAll(pageable);
    return appointmentsPage.map(AppointmentListingDTO::new);
    }

}

