package com.tpspring.repositories;

import com.tpspring.entities.MotCle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MotCleRepository extends JpaRepository<MotCle, Integer> {
}
