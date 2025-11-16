package com.personalproject.eu.OldDrive.Order;

import com.personalproject.eu.OldDrive.Client.ClientEntity;
import com.personalproject.eu.OldDrive.Employee.EmployeeEntity;
import com.personalproject.eu.OldDrive.TaskOrPart.TaskOrPartEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderEntity {

    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client")
    private ClientEntity clientEntity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "order_taskorpart",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "taskorpart_id")
    )
    private List<TaskOrPartEntity> listOfTaskOrPart = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_employee")
    private EmployeeEntity employeeEntity;

    @Column(name = "description")
    private String description;

    @Column(name = "total_value")
    private BigDecimal totalValue;

    @Column(name = "date")
    private LocalDateTime localDateTime;

    //CONSTRUCTOR
    public OrderEntity() {
    }

    public OrderEntity(ClientEntity clientEntity, EmployeeEntity employeeEntity, List<TaskOrPartEntity> listOfTaskOrPart, String description, BigDecimal totalValue, LocalDateTime localDateTime) {
        this.clientEntity = clientEntity;
        this.employeeEntity = employeeEntity;
        this.listOfTaskOrPart = listOfTaskOrPart;
        this.description = description;
        this.totalValue = totalValue;
        this.localDateTime = localDateTime;
    }

//GETTERS

    public ClientEntity getClientEntity() { return clientEntity; }
    public Long getId() { return id; }
    public List<TaskOrPartEntity> getListOfTaskOrPart() { return listOfTaskOrPart; }
    public EmployeeEntity getEmployeeEntity() { return employeeEntity; }
    public String getDescription() { return description; }
    public BigDecimal getTotalValue() { return totalValue; }
    public LocalDateTime getLocalDateTime() { return localDateTime; }

    //SETTERS
    public void setId(Long id) { this.id = id; }
    public void setClientEntity(ClientEntity clientEntity) { this.clientEntity = clientEntity; }
    public void setListOfTaskOrPart(List<TaskOrPartEntity> listOfTaskOrPart) { this.listOfTaskOrPart = listOfTaskOrPart; }
    public void setEmployeeEntity(EmployeeEntity employeeEntity) { this.employeeEntity = employeeEntity; }
    public void setTotalValue(BigDecimal totalValue) { this.totalValue = totalValue; }
    public void setDescription(String description) { this.description = description; }
    public void setLocalDateTime(LocalDateTime localDateTime) { this.localDateTime = localDateTime; }

}
