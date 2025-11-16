package com.personalproject.eu.OldDrive.Employee.CellphoneEmployeeEntity;

import com.personalproject.eu.OldDrive.Employee.EmployeeEntity;
import jakarta.persistence.*;

public class CellphoneEmployeeEntity {
    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cellphone_employee")
    private String cellphone;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private EmployeeEntity employeeEntity;
}
