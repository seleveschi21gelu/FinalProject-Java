package org.example.repository;

import org.example.entity.ConstructionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<ConstructionType,Integer> {
}
