package com.tpspring.repositories;

import com.tpspring.dto.NotificationDTO;
import com.tpspring.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    @Query("select n from Notification n where n.cible = ?1")
    List<NotificationDTO> findAllNotificationsByUtilisateur(Integer utilisateurId);
}
