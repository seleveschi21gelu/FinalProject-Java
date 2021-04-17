package org.example.controller;

import org.example.entity.DeliveryType;
import org.example.service.DeliveryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/deliveryType")
public class DeliveryTypeController {

    @Autowired
    private DeliveryTypeService deliveryTypeService;

    @GetMapping
    private ResponseEntity<List<DeliveryType>> findAllDeliveryType() {
        List<DeliveryType> deliveryTypes = deliveryTypeService.getAllDeliveryTypes();
        return new ResponseEntity(deliveryTypes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<DeliveryType> findDeliveryTypeById(@PathVariable Integer id) {
        DeliveryType deliveryType = deliveryTypeService.getDeliveryTypesById(id);
        return new ResponseEntity<>(deliveryType, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<DeliveryType> addDeliveryType(@RequestBody DeliveryType deliveryType) {
        deliveryTypeService.addDeliveryType(deliveryType);
        return new ResponseEntity<>(deliveryType, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<DeliveryType> updateFlatBlockById(@PathVariable Integer id, @RequestBody DeliveryType deliveryType) {
        deliveryType.setId(id);
        deliveryTypeService.updateDeliveryType(deliveryType);
        return new ResponseEntity<>(deliveryType, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteDeliveryType(@PathVariable Integer id) {
        deliveryTypeService.deleteDeliveryTypeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
