package com.tpspring.services;

import com.tpspring.dto.NotificationDTO;
import com.tpspring.entities.Notification;
import com.tpspring.entities.Projet;
import com.tpspring.entities.Utilisateur;
import com.tpspring.repositories.NotificationRepository;
import com.tpspring.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public NotificationDTO createOrUpdate(Notification notification) {
        notificationRepository.save(notification);
        return new NotificationDTO(notification);
    }

    public NotificationDTO getNotificationById(Integer id) {
        Notification notification = notificationRepository.findById(id).orElse(null);
        return new NotificationDTO(notification);
    }

    public List<NotificationDTO> getNotificationsByUtilisateurId(Integer id) {
        return notificationRepository.findAllNotificationsByUtilisateur(id);
    }

    public void deleteNotification(Notification notification) {
        notificationRepository.delete(notification);
    }

    public void notificationNouveauProjet(Projet projet) {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAllUtilisateurNotificationNouveauProjet();
        for (Utilisateur utilisateur : utilisateurs) {
            Notification notification = new Notification();
            notification.setNotification(projet.getNom()+" - Nouveau projet disponible");
            notification.setType("Projet");
            notification.setCible(utilisateur);
            this.createOrUpdate(notification);
        }
    }
}
