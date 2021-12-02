package com.tpspring.dto;

import com.tpspring.entities.*;

public class UtilisateurDTO extends Utilisateur {
    private Integer id;
    private String pseudo;
    private String nom;
    private String prenom;
    private Poste poste;

    public UtilisateurDTO(Utilisateur u) {
        this.setId(u.getId());
        this.setPseudo(u.getPseudo());
        this.setNom(u.getNom());
        this.setPrenom(u.getPrenom());
        this.setPoste(u.getPoste());
    }
}
