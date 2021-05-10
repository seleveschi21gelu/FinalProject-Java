package org.example.service;

import org.example.entity.PaidStatus;
import org.example.repository.PaidStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaidStatusService {

    @Autowired
    private PaidStatusRepository paidStatusRepository;

    public List<PaidStatus> getAllStatus() {
        List<PaidStatus>paidStatusList = new ArrayList<>();
        paidStatusList.add(new PaidStatus("Paid"));
        paidStatusList.add(new PaidStatus("Advance"));
        paidStatusList.add(new PaidStatus("Unpaid"));
        paidStatusRepository.saveAll(paidStatusList);

        return paidStatusRepository.findAll();
    }

    public PaidStatus getStatusById(Integer id) {
        return paidStatusRepository.findById(id).orElseThrow(() -> new RuntimeException("The status fom id " + id + "was not found"));
    }

    public PaidStatus addOrUpdateStatus(PaidStatus status) {
        return paidStatusRepository.save(status);
    }

    public void deleteStatusById(Integer id) {
        paidStatusRepository.deleteById(id);
    }


}
