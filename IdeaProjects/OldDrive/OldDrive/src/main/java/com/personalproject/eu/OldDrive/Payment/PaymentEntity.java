package com.personalproject.eu.OldDrive.Payment;


import com.personalproject.eu.OldDrive.Client.ClientEntity;
import com.personalproject.eu.OldDrive.Employee.EmployeeEntity;
import com.personalproject.eu.OldDrive.Order.OrderEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class PaymentEntity {

    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private Long idPayment;

    @OneToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity clientEntity;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employeeEntity;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Construtor padrão obrigatório
    public PaymentEntity() {
    }

    // Construtor com parâmetros
    public PaymentEntity(BigDecimal amount, String paymentMethod, OrderEntity orderEntity,
                         ClientEntity clientEntity, EmployeeEntity employeeEntity, String status) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.orderEntity = orderEntity;
        this.clientEntity = clientEntity;
        this.employeeEntity = employeeEntity;
        this.status = status;
        this.createdAt = LocalDateTime.now();
    }


    //GETTERS
    public Long getIdPayment() {return idPayment;}
    public BigDecimal getAmount() {return amount;}
    public String getPaymentMethod() {return paymentMethod;}
    public OrderEntity getOrderEntity() {return orderEntity;}
    public ClientEntity getClientEntity() {return clientEntity;}
    public EmployeeEntity getEmployeeEntity() {return employeeEntity;}
    public String getStatus() {return status;}
    public LocalDateTime getCreatedAt() {return createdAt;}

    //SETTERS
    public void setAmount(BigDecimal amount) {this.amount = amount;}
    public void setPaymentMethod(String paymentMethod) {this.paymentMethod = paymentMethod;}
    public void setOrderEntity(OrderEntity orderEntity) {this.orderEntity = orderEntity;}
    public void setClientEntity(ClientEntity clientEntity) {this.clientEntity = clientEntity;}
    public void setEmployeeEntity(EmployeeEntity employeeEntity) {this.employeeEntity = employeeEntity;}
    public void setStatus(String status) {this.status = status;}
    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}
}