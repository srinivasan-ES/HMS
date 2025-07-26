package com.management.HospitalClient.controller;

import com.management.HospitalClient.entity.AppointmentEntity;
import com.management.HospitalClient.service.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
@Slf4j
public class AppointmentController {

    private static final Logger logger = LoggerFactory.getLogger(AppointmentController.class);

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book-appointment/{patientId}")
    public AppointmentEntity saveOrUpdate(@PathVariable long patientId,@RequestBody AppointmentEntity appointmentEntity) {
        return appointmentService.createAppointment(patientId,appointmentEntity);
    }

    @GetMapping("/get-appointment/{id}")
    public AppointmentEntity getAppointment(@PathVariable long id) {
        return appointmentService.getAppointment(id);
    }

    @GetMapping("/get-appointments")
    public List<AppointmentEntity> getAppointmentList() {
        return appointmentService.getAppointmentList();
    }

    @DeleteMapping("/cancel-appointment/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return "Success";
    }

}
