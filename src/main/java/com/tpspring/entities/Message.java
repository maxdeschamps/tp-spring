package com.tpspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "messages")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="likes")
    private Integer likes;
    @Column(name="message")
    @NotNull
    private String message;
    // Le projet relié au message
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="projet_id", nullable=false)
    private Projet projet;
    // L'auteur du message
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="utilisateur_id", nullable=false)
    private Utilisateur utilisateur;

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
