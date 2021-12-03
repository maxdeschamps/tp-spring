package com.tpspring.dto;

import com.tpspring.entities.*;

import java.util.ArrayList;
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
        if (p.getNombrePatientsSouhaites() != null) {
            this.setNombrePatientsSouhaites(p.getNombrePatientsSouhaites());
        }
        if (p.getNombrePatientsIdentifies() != null) {
            this.setNombrePatientsIdentifies(p.getNombrePatientsIdentifies());
        }
        this.setForumDTO(p.getForum());
        this.setAuteurDTO(p.getAuteur());
        this.setMotsClesDTO(p.getMotsCles());
        this.setRequetesDTO(p.getRequetes());
        this.setAbonnesDTO(p.getAbonnes());
    }

    public void setNombrePatientsIdentifies(Integer nombrePatientsIdentifies) {
        this.nombrePatientsIdentifies = nombrePatientsIdentifies;
    }

    public List<MessageDTO> getForumDTO() {
        return forumDTO;
    }

    public void setForumDTO(List<Message> forum) {
        if (forum == null || forum.isEmpty()) {
            this.forumDTO = new ArrayList<>();
        } else {
            this.forumDTO = forum.stream().map(MessageDTO::new).collect(Collectors.toList());
        }
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
        if (motsCles == null || motsCles.isEmpty()) {
            this.motsClesDTO = new ArrayList<>();
        } else {
            this.motsClesDTO = motsCles.stream().map(MotCleDTO::new).collect(Collectors.toList());
        }
    }

    public List<RequeteDTO> getRequetesDTO() {
        return requetesDTO;
    }

    public void setRequetesDTO(List<Requete> requetes) {
        if (requetes == null || requetes.isEmpty()) {
            this.requetesDTO = new ArrayList<>();
        } else {
            this.requetesDTO = requetes.stream().map(RequeteDTO::new).collect(Collectors.toList());
        }
    }

    public List<UtilisateurDTO> getAbonnesDTO() {
        return abonnesDTO;
    }

    public void setAbonnesDTO(List<Utilisateur> abonnes) {
        if (abonnes == null || abonnes.isEmpty()) {
            this.abonnesDTO = new ArrayList<>();
        } else {
            this.abonnesDTO = abonnes.stream().map(UtilisateurDTO::new).collect(Collectors.toList());
        }
    }
}
