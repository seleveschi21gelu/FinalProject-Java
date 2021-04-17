package org.example.repository;

import org.example.entity.DeliveryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryTypeRepository extends JpaRepository<DeliveryType, Integer> {
    DeliveryType findByName(String deliveryType);
}
