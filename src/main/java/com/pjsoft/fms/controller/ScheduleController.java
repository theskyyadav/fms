package com.pjsoft.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.pjsoft.fms.mapper.PassengerMapper;

import com.pjsoft.fms.mapper.ScheduleMapper;

import com.pjsoft.fms.model.Passenger;

import com.pjsoft.fms.model.Schedule;

import com.pjsoft.fms.pojo.request.PassengerDTO;

import com.pjsoft.fms.pojo.request.ScheduleDTO;

import com.pjsoft.fms.pojo.response.PassengerResponseDTO;

import com.pjsoft.fms.pojo.response.ScheduleResponseDTO;

import com.pjsoft.fms.service.ScheduleService;

@RestController

@RequestMapping("/api/schedules")

public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired

    private ScheduleMapper scheduleMapper;

//    @GetMapping

//    public List<Schedule> getAllSchedules() {

//        return scheduleService.getAllSchedules();

//    }

//

//    @GetMapping("/{id}")

//    public ResponseEntity<Object> getScheduleById(@PathVariable Long id) {

//    	Schedule schedule = scheduleService.getScheduleById(id);

//        return ResponseEntity.ok(schedule);

//    }

//

//    @PostMapping

//    public Schedule createSchedule(@RequestBody Schedule schedule) {

//        return scheduleService.saveSchedule(schedule);

//    }

//

//    @PutMapping("/{id}")

//    public Schedule updateSchedule(@PathVariable Long id, @RequestBody Schedule schedule) {

//    	schedule.setId(id);

//        return scheduleService.saveSchedule(schedule);

//    }

//

//    @DeleteMapping("/{id}")

//    public void deleteSchedule(@PathVariable Long id) {

//    	scheduleService.deleteSchedule(id);

//    }

    @GetMapping

    public ResponseEntity<List<ScheduleResponseDTO>> getAllSchedules() {

        return ResponseEntity.ok(scheduleService.getAllSchedules());

    }

    @GetMapping("/{id}")

    public ResponseEntity<ScheduleResponseDTO> getScheduleById(@PathVariable Long id) {

        Schedule schedule = scheduleService.getScheduleById(id);

        return ResponseEntity.ok(scheduleMapper.entityToDtoMapper(schedule));

    }

    @PostMapping

    public ResponseEntity<ScheduleResponseDTO> createSchedule(@RequestBody ScheduleDTO scheduleDTO) {

        return new ResponseEntity<>(scheduleService.saveSchedule(scheduleDTO),HttpStatus.CREATED);

    }

    @PutMapping("/{id}")

    public ScheduleResponseDTO updateSchedule(@PathVariable Long id, @RequestBody ScheduleDTO scheduleDTO) {

        scheduleDTO.setId(id);

        return scheduleService.saveSchedule(scheduleDTO);

    }

    @DeleteMapping("/{id}")

    public void deleteSchedule(@PathVariable Long id) {

        scheduleService.deleteSchedule(id);

    }

}


