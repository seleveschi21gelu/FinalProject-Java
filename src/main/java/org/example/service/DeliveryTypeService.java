package org.example.service;

import org.example.entity.DeliveryType;
import org.example.repository.DeliveryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryTypeService {

    @Autowired
    private DeliveryTypeRepository deliveryTypeRepository;

    public List<DeliveryType> getAllDeliveryTypes() {
        return deliveryTypeRepository.findAll();
    }

    public DeliveryType getDeliveryTypesById(Integer id) {
        return deliveryTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("The deliveryType fom id " + id + "was not found"));
    }

    public DeliveryType addOrUpdateDeliveryType(DeliveryType deliveryType) {
        return deliveryTypeRepository.save(deliveryType);
    }

    public void deleteDeliveryTypeById(Integer id) {
        deliveryTypeRepository.deleteById(id);
    }


}
