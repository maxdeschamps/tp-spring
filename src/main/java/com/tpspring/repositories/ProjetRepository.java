package com.tpspring.repositories;

import com.tpspring.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Integer>, PagingAndSortingRepository<Projet, Integer> {

}
