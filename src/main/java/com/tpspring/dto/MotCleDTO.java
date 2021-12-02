package com.tpspring.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tpspring.entities.MotCle;
import com.tpspring.entities.Projet;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class MotCleDTO extends MotCle {
    private Integer id;
    private String nom;

    public MotCleDTO(MotCle mc) {
        this.setId(mc.getId());
        this.setNom(mc.getNom());
    }
}
