package com.employee.Employee.Allocation.System.entity;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Allocation
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Allocation {

    @Id
    private Long won;
    private Long employeeId;
    private String startDate;
    private String endDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empId")
    private Employee employee;
}
