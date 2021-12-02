package com.tpspring.dto;

import com.tpspring.entities.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ProjetDTO extends Projet {
    private Integer id;
    private String nom;
    private String description;
    private Date dateCreation;
    private Date dateModification;
    private Date dateCloture;
    private Integer nombrePatientsSouhaites;
    private Integer nombrePatientsIdentifies;
    private List<MessageDTO> forumDTO;
    private UtilisateurDTO auteurDTO;
    private List<MotCleDTO> motsClesDTO;
    private List<RequeteDTO> requetesDTO;
    private List<UtilisateurDTO> abonnesDTO;

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
        this.setAuteurDTO(p.getAuteur());
        this.setMotsClesDTO(p.getMotsCles());
        this.setRequetesDTO(p.getRequetes());
        this.setAbonnesDTO(p.getAbonnes());
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

    public UtilisateurDTO getAuteurDTO() {
        return auteurDTO;
    }

    public void setAuteurDTO(Utilisateur auteur) {
        this.auteurDTO = new UtilisateurDTO(auteur);
    }

    public List<MotCleDTO> getMotsClesDTO() {
        return motsClesDTO;
    }

    public void setMotsClesDTO(List<MotCle> motsCles) {
        this.motsClesDTO = motsCles.stream().map(MotCleDTO::new).collect(Collectors.toList());
    }

    public List<RequeteDTO> getRequetesDTO() {
        return requetesDTO;
    }

    public void setRequetesDTO(List<Requete> requetes) {
        this.requetesDTO = requetes.stream().map(RequeteDTO::new).collect(Collectors.toList());
    }

    public List<UtilisateurDTO> getAbonnesDTO() {
        return abonnesDTO;
    }

    public void setAbonnesDTO(List<Utilisateur> abonnes) {
        this.abonnesDTO = abonnes.stream().map(UtilisateurDTO::new).collect(Collectors.toList());
    }
}
