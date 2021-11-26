package com.tpspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="pseudo")
    @NotNull
    private String pseudo;
    @Column(name = "mot_de_passe")
    @NotNull
    @JsonIgnore
    private String motDePasse;
    @Column(name="nom")
    @NotNull
    private String nom;
    @Column(name="prenom")
    @NotNull
    private String prenom;
    @Column(name="poste")
    @NotNull
    private Poste poste;
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
    @OneToMany(mappedBy = "auteur")
    private List<Requete> requetes;
    // Liste des projets dans lesquels l'utilisateur est abonné
    @ManyToMany(mappedBy = "abonnes")
    @JsonIgnore
    private List<Projet> projetsAbonne;

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

    public List<Requete> getRequetes() {
        return requetes;
    }

    public void setRequetes(List<Requete> requetes) {
        this.requetes = requetes;
    }

    public List<Projet> getProjetsAbonne() {
        return projetsAbonne;
    }

    public void setProjetsAbonne(List<Projet> projetsAbonne) {
        this.projetsAbonne = projetsAbonne;
    }
}
