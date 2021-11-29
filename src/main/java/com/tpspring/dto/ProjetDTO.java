package com.tpspring.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tpspring.entities.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProjetDTO extends Projet {
    private Integer id;
    private String nom;
    private String description; // (détaillée)
    private Date dateCreation; // de création
    private Date dateModification; // de modification
    private Date dateCloture; // de clôture
    private Integer nombrePatientsSouhaites; // de patients souhaités sur le projet
    private Integer nombrePatientsIdentifies; // total de patients identifiés, calculé grâce aux patients identifiés par chaque participant
//    private List<MessageDTO> forum;
//    private UtilisateurDTO auteur;
//    private List<MotCleDTO> motsCles;
//    private List<ProjetParticipantDTO> projetParticipants;
//    private List<RequeteDTO> requetes;
//    private List<UtilisateurDTO> abonnes; //d’abonnés, qui sont notifiés quand il se passe quelque chose de nouveau

    public ProjetDTO(Projet p) {
        this.setId(p.getId());
        this.setNom(p.getNom());
        this.setDescription(p.getDescription());
        this.setDateCreation(p.getDateCreation());
        this.setDateModification(p.getDateModification());
        this.setDateCloture(p.getDateCloture());
        this.setNombrePatientsSouhaites(p.getNombrePatientsSouhaites());
        this.setNombrePatientsIdentifies(p.getNombrePatientsIdentifies());
//        this.setForum(p.getForum());
//        this.setAuteur(p.getAuteur());
//        this.setMotsCles(p.getMotsCles());
//        this.setProjetParticipants(p.getProjetParticipants());
    }

    public void setNombrePatientsIdentifies(Integer nombrePatientsIdentifies) {
        this.nombrePatientsIdentifies = nombrePatientsIdentifies;
    }

    @Override
    public Integer getNombrePatientsIdentifies() {
        return nombrePatientsIdentifies;
    }
//
//    @Override
//    public List<MessageDTO> getForum() {
//        return forum;
//    }
//
//    public void setForum(List<MessageDTO> forum) {
//        this.forum = forum;
//    }
//
//    @Override
//    public UtilisateurDTO getAuteur() {
//        return auteur;
//    }
//
//    public void setAuteur(UtilisateurDTO auteur) {
//        this.auteur = auteur;
//    }
//
//    @Override
//    public List<MotCleDTO> getMotsCles() {
//        return motsCles;
//    }
//
//    public void setMotsCles(List<MotCleDTO> motsCles) {
//        this.motsCles = motsCles;
//    }
//
//    @Override
//    public List<ProjetParticipantDTO> getProjetParticipants() {
//        return projetParticipants;
//    }
//
//    public void setProjetParticipants(List<ProjetParticipantDTO> projetParticipants) {
//        this.projetParticipants = projetParticipants;
//    }
//
//    @Override
//    public List<RequeteDTO> getRequetes() {
//        return requetes;
//    }
//
//    public void setRequetes(List<RequeteDTO> requetes) {
//        this.requetes = requetes;
//    }
//
//    @Override
//    public List<UtilisateurDTO> getAbonnes() {
//        return abonnes;
//    }
//
//    public void setAbonnes(List<UtilisateurDTO> abonnes) {
//        this.abonnes = abonnes;
//    }
}
