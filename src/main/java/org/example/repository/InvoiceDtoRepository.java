package org.example.repository;

import org.example.entity.InvoiceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDtoRepository extends JpaRepository<InvoiceDTO,Integer> {


}
