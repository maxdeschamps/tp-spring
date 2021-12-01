package com.tpspring.controllers;

import com.tpspring.dto.NotificationDTO;
import com.tpspring.entities.Notification;
import com.tpspring.services.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @Operation(summary = "Récupération de toutes les notifications d'un utilisateur")
    @RequestMapping(path = "/notifications", method = RequestMethod.GET)
    public List<NotificationDTO> getUtilisateurNotifications(@RequestParam(value = "id") Integer id) {
        return notificationService.getNotificationsByUtilisateurId(id);
    }

    @Operation(summary = "Récupération une notification")
    @RequestMapping(path = "/notification", method = RequestMethod.GET)
    public NotificationDTO getNotification(@RequestParam(value = "id") Integer id) {
        return notificationService.getNotificationById(id);
    }

    @Operation(summary = "Création ou mise à jour d'une requête")
    @RequestMapping(path = "/notification", method = RequestMethod.PUT)
    public NotificationDTO addOrUpdateNotification(@Valid @RequestBody Notification notification) {
        return notificationService.createOrUpdate(notification);
    }

    @Operation(summary = "Suppression d'une notification à partir de son identifiant")
    @RequestMapping(path = "/notification", method = RequestMethod.DELETE)
    public void deleteNotification(@RequestParam(value = "id") Integer id) {
        notificationService.deleteNotification(notificationService.getNotificationById(id));
    }
}
