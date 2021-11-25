package com.tpspring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "notifications")
public class Notification implements Serializable {
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="type")
    private String type;

    @Column(name="notification")
    private String notification;

}
