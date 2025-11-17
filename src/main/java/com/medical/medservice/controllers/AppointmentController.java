package com.medical.medservice.controllers;

import com.medical.medservice.domains.appointment.*;
import com.medical.medservice.infra.exceptions.AppointmentException;
import com.medical.medservice.repositories.AppointmentRepository;
import com.medical.medservice.services.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private AppointmentService service;

    @PostMapping
    @Transactional
    public ResponseEntity createAppointment (@RequestBody @Valid AppointmentCreationDTO data, UriComponentsBuilder uriBuilder){
        var appointment = new Appointment(data);

        try{
            service.checkDisponibility(appointment);
        }catch(AppointmentException exception){
            return ResponseEntity.status(400).body(exception.getMessage());
        }

        repository.save(appointment);

        var uri = uriBuilder.path("/appointments/{id}").buildAndExpand(appointment.getId()).toUri();
        return ResponseEntity.created(uri).body(new AppointmentDetailsDTO(appointment));
    }

    @GetMapping("{id}")
    public ResponseEntity detailAppointment (@PathVariable Long id){
        var topic = repository.getReferenceById(id);
        return ResponseEntity.ok(new AppointmentDetailsDTO(topic));
    }

    @GetMapping
    public ResponseEntity<Page<AppointmentListingDTO>> listAppointments (@RequestParam(value = "pages", defaultValue = "0") Integer pages,
                                                                               @RequestParam(value = "size", defaultValue = "10") Integer size){
        Pageable pageable = PageRequest.of(pages, size);
        var page = service.listAppointments(pageable);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody AppointmentRefreshDTO refreshData){
        var appointment = repository.getReferenceById(refreshData.id());
        appointment.updateAppointment(refreshData);
        return ResponseEntity.ok(new AppointmentDetailsDTO(appointment));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity cancel(@PathVariable Long id){
        repository.getReferenceById(id).cancel();
        return ResponseEntity.noContent().build();
    }


}
