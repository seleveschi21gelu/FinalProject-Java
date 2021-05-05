package org.example.repository;

import org.example.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material,Integer> {
    Material findByName(String materialAndExecution);



}
