package com.tpspring.repositories;

import com.tpspring.entities.Requete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RequeteRepository extends JpaRepository<Requete, UUID> {
}
