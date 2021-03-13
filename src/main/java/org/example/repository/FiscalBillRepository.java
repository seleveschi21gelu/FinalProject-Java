package org.example.repository;

import org.example.entity.FiscalBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiscalBillRepository extends JpaRepository<FiscalBill,Integer> {


}
