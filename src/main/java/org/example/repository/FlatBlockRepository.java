package org.example.repository;

import org.example.entity.FlatBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatBlockRepository extends JpaRepository<FlatBlock, Integer> {
}
