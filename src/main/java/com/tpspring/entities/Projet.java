package com.tpspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "projets")
public class Projet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="nom")
    @NotNull
    private String nom;
    @Column(name="description")
    private String description; // (détaillée)
    @Column(name="date_creation")
    @NotNull
    private Date dateCreation; // de création
    @Column(name="date_modification")
    @NotNull
    private Date dateModification; // de modification
    @Column(name="date_cloture")
    private Date dateCloture; // de clôture
    @Column(name="nombre_patients_souhaites")
    private Integer nombrePatientsSouhaites; // de patients souhaités sur le projet
    // Liste des messages du projet
    @OneToMany(mappedBy = "projet")
    @JsonIgnore
    private List<Message> forum;
    // Auteur du projet
    @ManyToOne
    @JoinColumn(name="utilisateur_id", nullable=false)
    @JsonIgnore
    private Utilisateur auteur;
    // Liste des mots clés reliés au projet
    @ManyToMany
    @JoinTable(name = "projets_mots_cles",
            joinColumns = @JoinColumn(name = "projet_id"),
            inverseJoinColumns = @JoinColumn(name = "mot_cle_id")
    )
    @JsonIgnore
    private List<MotCle> motsCles;
    // Liste des utilisateurs participants au projet
    @OneToMany(mappedBy = "projet")
    @JsonIgnore
    private List<ProjetParticipant> projetParticipants;
    // Liste des requêtes, qui doivent être validées par l’auteur
    @OneToMany(mappedBy="projet")
    @JsonIgnore
    private List<Requete> requetes;
    // Liste des utilisateurs abonnés au projet
    @ManyToMany
    @JoinTable(name = "projets_abonnes",
        joinColumns = @JoinColumn(name = "projet_id"),
        inverseJoinColumns = @JoinColumn(name = "utilisateur_id")
    )
    @JsonIgnore
    private List<Utilisateur> abonnes; //d’abonnés, qui sont notifiés quand il se passe quelque chose de nouveau

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Utilisateur getAuteur() {
        return auteur;
    }

    public void setAuteur(Utilisateur auteur) {
        this.auteur = auteur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateCloture() {
        return dateCloture;
    }

    public void setDateCloture(Date dateCloture) {
        this.dateCloture = dateCloture;
    }

    public List<Message> getForum() {
        return forum;
    }

    public void setForum(List<Message> forum) {
        this.forum = forum;
    }

    public List<MotCle> getMotsCles() {
        return motsCles;
    }

    public void setMotsCles(List<MotCle> motsCles) {
        this.motsCles = motsCles;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public Integer getNombrePatientsSouhaites() {
        return nombrePatientsSouhaites;
    }

    public void setNombrePatientsSouhaites(Integer nombrePatientsSouhaites) {
        this.nombrePatientsSouhaites = nombrePatientsSouhaites;
    }

    public List<Requete> getRequetes() {
        return requetes;
    }

    public void setRequetes(List<Requete> requetes) {
        this.requetes = requetes;
    }

    public List<Utilisateur> getAbonnes() {
        return abonnes;
    }

    public void setAbonnes(List<Utilisateur> abonnes) {
        this.abonnes = abonnes;
    }

    public List<ProjetParticipant> getProjetParticipants() {
        return projetParticipants;
    }

    public void setProjetParticipants(List<ProjetParticipant> projetParticipants) {
        this.projetParticipants = projetParticipants;
    }

    public Integer getNombrePatientsIdentifies() {
        Integer nombrePatientsIdentifies = 0;

        if (projetParticipants == null) {
            return 0;
        }

        for (ProjetParticipant projetParticipant: projetParticipants) {
            if (projetParticipant.getValide()) {
                Integer participants = 0;
                if (projetParticipant.getNombrePatientsIdentifies() != null) {
                    participants = projetParticipant.getNombrePatientsIdentifies();
                }
                nombrePatientsIdentifies += participants;
            }
        }

        return nombrePatientsIdentifies;
    }
}
