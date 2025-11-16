package com.personalproject.eu.OldDrive.Employee;

import com.personalproject.eu.OldDrive.Order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<OrderEntity, Long> {

}
