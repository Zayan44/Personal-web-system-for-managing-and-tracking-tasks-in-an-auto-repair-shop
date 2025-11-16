package com.personalproject.eu.OldDrive.Vehicle;

import com.personalproject.eu.OldDrive.Client.ClientEntity;
import com.personalproject.eu.OldDrive.Employee.EmployeeEntity;
import jakarta.persistence.*;

@Entity
public class VehicleEntity {

    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehicle")
    private Long idVehicle;

    @Column(name = "licenseplate")
    private String licensePlate;

    @Column(name = "color")
    private String colorVehicle;

    @Column(name = "age_vehicle")
    private short ageVehicle;

    @Column(name = "model")
    private String modelVehicle;

    @Column(name = "brand")
    private String brandVehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_vehicle")
    private ClientEntity clientEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_responsible")
    private EmployeeEntity employeeEntity;


    //CONSTRUCTOR
    public VehicleEntity() {
    }

    public VehicleEntity(String licensePlate, String colorVehicle, short ageVehicle, String modelVehicle, String brandVehicle, ClientEntity clientEntity, EmployeeEntity employeeEntity) {
        this.licensePlate = licensePlate;
        this.colorVehicle = colorVehicle;
        this.ageVehicle = ageVehicle;
        this.modelVehicle = modelVehicle;
        this.brandVehicle = brandVehicle;
        this.clientEntity = clientEntity;
        this.employeeEntity = employeeEntity;
    }

    //GETTERS
    public Long getIdVehicle() {return idVehicle;}
    public String getLicensePlate() {return licensePlate;}
    public String getColorVehicle() {return colorVehicle;}
    public short getAgeVehicle() {return ageVehicle;}
    public String getModelVehicle() {return modelVehicle;}
    public String getBrandVehicle() {return brandVehicle;}
    public ClientEntity getClientEntity() {return clientEntity;}
    public EmployeeEntity getEmployeeEntity() {return employeeEntity;}

    //SETTERS
    public void setIdVehicle(Long idVehicle) {this.idVehicle = idVehicle;}
    public void setLicensePlate(String licensePlate) {this.licensePlate = licensePlate;}
    public void setAgeVehicle(short ageVehicle) {this.ageVehicle = ageVehicle;}
    public void setColorVehicle(String colorVehicle) {this.colorVehicle = colorVehicle;}
    public void setBrandVehicle(String brandVehicle) {this.brandVehicle = brandVehicle;}
    public void setModelVehicle(String modelVehicle) {this.modelVehicle = modelVehicle;}
    public void setClientEntity(ClientEntity clientEntity) {this.clientEntity = clientEntity;}
    public void setEmployeeEntity(EmployeeEntity employeeEntity) {this.employeeEntity = employeeEntity;}
}


