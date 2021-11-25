package com.tpspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjetRepository extends JpaRepository<ProjetRepository, UUID> {

}
