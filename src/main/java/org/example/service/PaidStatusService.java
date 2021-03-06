package org.example.service;

import org.example.entity.PaidStatus;
import org.example.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaidStatusService {

    @Autowired
    private StatusRepository statusRepository;

    public List<PaidStatus> getAllStatus() {
        return statusRepository.findAll();
    }

    public PaidStatus getStatusById(Integer id) {
        return statusRepository.findById(id).orElseThrow(() -> new RuntimeException("The status fom id " + id + "was not found"));
    }

    public PaidStatus addOrUpdateStatus(PaidStatus status) {
        return statusRepository.save(status);
    }

    public void deleteStatusById(Integer id) {
        statusRepository.deleteById(id);
    }


}
