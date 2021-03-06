package org.example.repository;

import org.example.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProvidersRepository extends JpaRepository<Provider, Integer> {


}
