package org.example.repository;

import org.example.entity.MaterialAndExecution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<MaterialAndExecution,Integer> {
    MaterialAndExecution findByName(String materialAndExecution);



}
