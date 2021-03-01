package org.example.controller;

import org.example.entity.enums.Status;
import org.example.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    private ResponseEntity<List<Status>> getAllStatus() {
        List<Status> statusList = statusService.getAllStatus();
        return new ResponseEntity<>(statusList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Status> getStatusById(@PathVariable Integer id) {
        Status status = statusService.getStatusById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Status> addStatus(@RequestBody Status status) {
        Status addStatus = statusService.addOrUpdateStatus(status);
        return new ResponseEntity<>(addStatus, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    private ResponseEntity<Status>updateStatusById(@RequestBody Status status, @PathVariable Integer id){
        status.setId(id);
        statusService.addOrUpdateStatus(status);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Status>deleteStatusById(@PathVariable Integer id){
        statusService.deleteStatusById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
