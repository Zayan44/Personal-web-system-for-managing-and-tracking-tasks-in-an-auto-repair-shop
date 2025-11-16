package com.personalproject.eu.OldDrive.Client.CellphoneClientEntity.java;

import jakarta.persistence.*;
import com.personalproject.eu.OldDrive.Client.ClientEntity;

@Entity
public class CellphoneClientEntity {

    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cellphone_client")
    private String cellphone;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private ClientEntity clientEntity;
}