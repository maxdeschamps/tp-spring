package com.tpspring.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tpspring.entities.Message;
import com.tpspring.entities.Projet;
import com.tpspring.entities.Utilisateur;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class MessageDTO extends Message {
    private Integer id;
    private Integer likes;
    private String message;
//    private ProjetDTO projetDTO;
//    private UtilisateurDTO auteurDTO;

    public MessageDTO(Message m) {
        this.setId(m.getId());
        this.setLikes(m.getLikes());
        this.setMessage(m.getMessage());
    }
}
