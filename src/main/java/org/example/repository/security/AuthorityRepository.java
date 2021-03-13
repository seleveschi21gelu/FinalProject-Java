package org.example.repository.security;


import org.example.entity.security.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository  extends JpaRepository<AuthorityEntity,Integer> {
}
