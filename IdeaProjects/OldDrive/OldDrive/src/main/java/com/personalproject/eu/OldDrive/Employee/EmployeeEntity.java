package com.personalproject.eu.OldDrive.Employee;

import jakarta.persistence.*;

@Entity
public class EmployeeEntity {

    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_employee")
    private Long id;

    @Column(name = "firstname_employee")
    private String firstName;

    @Column(name = "lastname_employee")
    private String lastName;

    @Column(name = "position_employee")
    private String position;

    @Column(name = "cpf_employee")
    private String cpf;

    @Column(name = "email_employee")
    private String email;

    @Column(name = "password_employee")
    private String password;

    //CONSTRUCTOR
    public EmployeeEntity() {
    }

    public EmployeeEntity(String firstName, String lastName, String cpf, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }

    //GETTERS
    public String getPassword() { return password; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getPosition() {return position;}

    //SETTERS
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public void setEmail(String email) {this.email = email;}
    public void setPassword(String password) {this.password = password;}
    public void setPosition(String position) {this.position = position;}
 }


