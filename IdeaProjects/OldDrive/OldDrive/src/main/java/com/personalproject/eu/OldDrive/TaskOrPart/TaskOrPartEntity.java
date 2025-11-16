package com.personalproject.eu.OldDrive.TaskOrPart;

import jakarta.persistence.*;

@Entity
public class TaskOrPartEntity {

    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_taskorpart")
    private Long id;

    @Column(name = "name_taskorpart")
    private String name;

    @Column(name = "value_unit")
    private float value_unit;

    @Column(name = "age_fabrication")
    private short age;

    @Column(name = "supplier")
    private String supplier;

    //CONSTRUCTOR
    public TaskOrPartEntity() {
    }

    public TaskOrPartEntity(String name, short age, float value_unit, String supplier) {
        this.name = name;
        this.age = age;
        this.value_unit = value_unit;
        this.supplier = supplier;
    }

    //GETTERS
    public String getName() {return name;}
    public Long getId() {return id;}
    public float getValue_unit() {return value_unit;}
    public short getAge() {return age;}
    public String getSupplier() {return supplier;}

    //SETTERS
    public void setId(Long id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setValue_unit(float value_unit) {this.value_unit = value_unit;}
    public void setAge(short age) {this.age = age;}
    public void setSupplier(String supplier) {this.supplier = supplier;}
}



