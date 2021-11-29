package com.tpspring.dto;

import com.tpspring.entities.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ProjetDTO extends Projet {
    private Integer id;
    private String nom;
    private String description; // (détaillée)
    private Date dateCreation; // de création
    private Date dateModification; // de modification
    private Date dateCloture; // de clôture
    private Integer nombrePatientsSouhaites; // de patients souhaités sur le projet
    private Integer nombrePatientsIdentifies; // total de patients identifiés, calculé grâce aux patients identifiés par chaque participant
    private List<MessageDTO> forumDTO;
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
        this.setForumDTO(p.getForum());
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

    public List<MessageDTO> getForumDTO() {
        return forumDTO;
    }

    public void setForumDTO(List<Message> forum) {
        this.forumDTO = forum.stream().map(MessageDTO::new).collect(Collectors.toList());
    }
}
