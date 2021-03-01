package org.example.repository;

import org.example.entity.enums.DeliveryType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryTypeRepository extends JpaRepository<DeliveryType, Integer> {
}
