package com.tpspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "motcles")
public class MotCle implements Serializable {
    @Id
    @Column(name="id")
    private UUID id;
    @Column(name="nom")
    @NotNull
    private String nom;
    // Liste des projets reliés aux mots clés
    @ManyToMany(mappedBy = "motsCles")
    @JsonIgnore
    private List<Projet> projets;
}
