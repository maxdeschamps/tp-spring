package com.tpspring.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "patients")
public class Requete implements Serializable {
    @Id
    @Column(name="id")
    private UUID id;
    @Column(name="valide")
    private Boolean valide;
    @Column(name="requete")
    @NotNull
    private String requete;
    @Column(name="date_creation")
    @NotNull
    private Date dateCreation;
    // Le projet relié à la requête
    @ManyToOne
    @JoinColumn(name="projet_id", nullable=false)
    private Projet projet;
    // L'auteur de la requête
    @ManyToOne
    @JoinColumn(name="utilisateur_id", nullable=false)
    private Utilisateur auteurRequete;
}
