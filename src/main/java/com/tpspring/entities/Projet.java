package com.tpspring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Projet implements Serializable {
    @Id
    @Column(name="id")
    private UUID id;
    @Column(name="nom")
    private String nom;
    @Column(name="auteur")
    private Utilisateur auteur; // (créateur du projet)
    @Column(name="description")
    private String description; // (détaillée)
    @Column(name="date_creation")
    private Date dateCreation; // de création
    @Column(name="date_cloture")
    private Date dateCloture; // de clôture
    @Column(name="nombre_patients_souhaites")
    private Integer nombrePatientsSouhaites; // de patients souhaités sur le projet
    @Column(name="nombre_patients_identifies")
    private Integer nombrePatientsIdentifies; // total de patients identifiés, calculé grâce aux patients identifiés par chaque participant
// TODO: Relations à créer, les columns ne sont pas corrects
    private List<Message> forum; // (liste de messages)
    private List<MotCle> motsCles; // -clés
    private List<Requete> listeRequetes; // de requêtes, qui doivent être validées par l’auteur
    private List<Patient> listeParticpants; //de participants, qui doivent être validés par l’auteur
    private List<Patient> listeAbonnes; //d’abonnés, qui sont notifiés quand il se passe quelque chose de nouveau

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

    public List<Patient> getNombrePatientsSouhaites() {
        return nombrePatientsSouhaites;
    }

    public void setNombrePatientsSouhaites(List<Patient> nombrePatientsSouhaites) {
        this.nombrePatientsSouhaites = nombrePatientsSouhaites;
    }

    public List<Patient> getNombrePatientsIdentifies() {
        return nombrePatientsIdentifies;
    }

    public void setNombrePatientsIdentifies(List<Patient> nombrePatientsIdentifies) {
        this.nombrePatientsIdentifies = nombrePatientsIdentifies;
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

    public List<Requete> getListeRequetes() {
        return listeRequetes;
    }

    public void setListeRequetes(List<Requete> listeRequetes) {
        this.listeRequetes = listeRequetes;
    }

    public List<Patient> getListeParticpants() {
        return listeParticpants;
    }

    public void setListeParticpants(List<Patient> listeParticpants) {
        this.listeParticpants = listeParticpants;
    }

    public List<Patient> getListeAbonnes() {
        return listeAbonnes;
    }

    public void setListeAbonnes(List<Patient> listeAbonnes) {
        this.listeAbonnes = listeAbonnes;
    }
}
