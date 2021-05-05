package org.example.repository;

import org.example.entity.PaidStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaidStatusRepository extends JpaRepository<PaidStatus,Integer> {

    PaidStatus findByName(String paidStatus);

}
