package org.example.repository;

import org.example.entity.Providers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProvidersRepository extends JpaRepository<Providers, Integer> {


}
