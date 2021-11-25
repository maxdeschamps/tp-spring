package com.tpspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "patients")
public class Patient implements Serializable {
    @Id
    @Column(name="id")
    private UUID id;
    // Liste des projets dans lesquels le patient participe
    @ManyToMany(mappedBy = "participants")
    @JsonIgnore
    private List<Projet> projetsParticipant;

    public List<Projet> getProjetsParticipant() {
        return projetsParticipant;
    }

    public void setProjetsParticipant(List<Projet> projetsParticipant) {
        this.projetsParticipant = projetsParticipant;
    }
}
