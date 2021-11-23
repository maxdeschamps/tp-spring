package com.tpspring.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

public class Utilisateur implements Serializable {
    @Id
    @Column(name="id")
    private UUID id;
    @Column(name="nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;
    @Column(name="role")
    private Role role;
    @Column(name="service")
    private Service service;
}
