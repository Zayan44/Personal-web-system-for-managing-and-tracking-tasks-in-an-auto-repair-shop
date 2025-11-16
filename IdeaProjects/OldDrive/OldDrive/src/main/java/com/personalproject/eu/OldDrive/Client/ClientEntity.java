package com.personalproject.eu.OldDrive.Client;

import jakarta.persistence.*;

@Entity
public class ClientEntity {

    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_client")
    private Long id;

    @Column(name = "firstname_client")
    private String firstName;

    @Column(name = "lastname_client")
    private String lastName;

    @Column(name = "cpf_client")
    private String cpf;

    @Column(name = "email_client")
    private String email;

    @Column(name = "password_client")
    private String password;

    //CONSTRUCTOR
    public ClientEntity() {
    }

    public ClientEntity(String firstName, String lastName, String cpf, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf; //brazilian id
        this.email = email;
        this.password = password;
    }

    //GETTERS
    public String getPassword() { return password; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}

    //SETTERS
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public void setEmail(String email) {this.email = email;}
    public void setPassword(String password) {this.password = password;}
}
