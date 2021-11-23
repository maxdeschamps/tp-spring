package com.tpspring.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

public class Service implements Serializable {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name="nom")
    private String nom;
}
