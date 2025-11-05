package com.medical.medservice.controller;

import com.medical.medservice.domain.appointment.*;
import com.medical.medservice.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class AppointmentController {

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private AppointmentService service;

    @PostMapping
    @Transactional
    public ResponseEntity createAppointment (@RequestBody AppointmentCreationDTO data, UriComponentsBuilder uriBuilder){

        var appointment = new Appointment(data);

        repository.save(appointment);

        var uri = uriBuilder.path("/consultas/{id}").buildAndExpand(appointment.getId()).toUri();
        return ResponseEntity.created(uri).body(new AppointmentDetailsDTO(appointment));
    }

    @GetMapping("{id}")
    public ResponseEntity detailAppointment (@PathVariable Long id){
        var topic = repository.getReferenceById(id);
        return ResponseEntity.ok(new AppointmentDetailsDTO(topic));
    }

    @GetMapping
    public ResponseEntity<Page<AppointmentListingDTO>> listAppointments (@RequestParam(value = "pages", defaultValue = "0") Integer pages,
                                                                         @RequestParam(value = "size", defaultValue = "12") Integer size){

        var page = service.listAppointments(pages,size);


        return ResponseEntity.ok(page);
    }

}
