package com.tpspring.dto;

import com.tpspring.entities.Notification;

public class NotificationDTO extends Notification {
    private Integer id;
    private Integer cible;
    private String type;
    private String notification;


    public NotificationDTO(Notification n) {
        this.setId(n.getId());
        this.setCible(n.getCible());
        this.setType(n.getType());
        this.setNotification(n.getNotification());
    }
}
