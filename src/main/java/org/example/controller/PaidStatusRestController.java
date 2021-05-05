package org.example.controller;

import org.example.entity.PaidStatus;
import org.example.service.PaidStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/paidStatus")
public class PaidStatusRestController {

    @Autowired
    private PaidStatusService paidStatusService;

    @GetMapping
    private ResponseEntity<List<PaidStatus>> getAllStatus() {
        List<PaidStatus> statusList = paidStatusService.getAllStatus();
        return new ResponseEntity<>(statusList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<PaidStatus> getStatusById(@PathVariable Integer id) {
        PaidStatus status = paidStatusService.getStatusById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<PaidStatus> addStatus(@RequestBody PaidStatus status) {
        PaidStatus addStatus = paidStatusService.addOrUpdateStatus(status);
        return new ResponseEntity<>(addStatus, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    private ResponseEntity<PaidStatus>updateStatusById(@RequestBody PaidStatus status, @PathVariable Integer id){
        status.setId(id);
        paidStatusService.addOrUpdateStatus(status);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<PaidStatus>deleteStatusById(@PathVariable Integer id){
        paidStatusService.deleteStatusById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
