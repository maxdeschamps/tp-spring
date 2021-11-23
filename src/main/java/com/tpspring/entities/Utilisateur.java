package com.tpspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur implements Serializable {
    @Id
    @Column(name="id")
    private UUID id;
    @Column(name="pseudo")
    @NotNull
    private String pseudo;
    @Column(name = "motdepasse")
    @NotNull
    @JsonIgnore
    private String motdepasse;
    @Column(name="nom")
    @NotNull
    private String nom;
    @Column(name="prenom")
    @NotNull
    private String prenom;
    @Column(name="role")
    @NotNull
    private Role role;
    // Service dans lequel est l'utilisateur
    @ManyToOne
    @JoinColumn(name="service_id", nullable=false)
    private Service service;
    // Liste des messages de l'utilisateur
    @OneToMany(mappedBy = "utilisateur")
    private List<Message> messages;
    // Liste des projets dans lesquels l'utilisateur en est l'auteur
    @OneToMany(mappedBy = "auteur")
    private List<Projet> projets;
    // Liste des requêtes dont l'utilisateur en est l'auteur
    @OneToMany(mappedBy = "auteurRequete")
    private List<Requete> requetes;
    // Liste des projets dans lesquels l'utilisateur est abonné
    @ManyToMany(mappedBy = "abonnes")
    @JsonIgnore
    private List<Projet> projetsAbonne;
}
