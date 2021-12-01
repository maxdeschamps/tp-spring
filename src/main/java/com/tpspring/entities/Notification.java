package com.tpspring.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "notifications")
public class Notification implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="type")
    private String type;

    @Column(name="notification")
    private String notification;

    // La cible de la notification
    @ManyToOne
    @JoinColumn(name="utilisateur_id", nullable=false)
    private Utilisateur cible;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public Utilisateur getCible() {
        return cible;
    }

    public void setCible(Utilisateur cible) {
        this.cible = cible;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
