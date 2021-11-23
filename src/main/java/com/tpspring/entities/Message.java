package com.tpspring.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "messages")
public class Message implements Serializable {
    @Id
    @Column(name="id")
    private UUID id;
    @Column(name="likes")
    private Integer likes;
    @Column(name="message")
    @NotNull
    private String message;
    // Le projet relié au message
    @ManyToOne
    @JoinColumn(name="projet_id", nullable=false)
    private Projet projet;
    // L'auteur du message
    @ManyToOne
    @JoinColumn(name="utilisateur_id", nullable=false)
    private Utilisateur utilisateur;
}
