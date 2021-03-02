package org.example.service;

import org.example.entity.Status;
import org.example.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    public Status getStatusById(Integer id) {
        return statusRepository.findById(id).orElseThrow(() -> new RuntimeException("The status fom id " + id + "was not found"));
    }

    public Status addOrUpdateStatus(Status status) {
        return statusRepository.save(status);
    }

    public void deleteStatusById(Integer id) {
        statusRepository.deleteById(id);
    }


}
