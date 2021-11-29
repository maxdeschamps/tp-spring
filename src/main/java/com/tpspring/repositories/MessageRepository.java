package com.tpspring.repositories;

import com.tpspring.entities.Message;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>, PagingAndSortingRepository<Message, Integer> {
    @Query("select m from Message m where m.projet = ?1")
    List<Message> findAllMessagesByProjet(Integer projetId, Pageable pageable);

    @Query("select m from Message m where m.utilisateur = ?1")
    List<Message> findAllMessagesByUtilisateur(Integer utilisateurId, Pageable pageable);
}
