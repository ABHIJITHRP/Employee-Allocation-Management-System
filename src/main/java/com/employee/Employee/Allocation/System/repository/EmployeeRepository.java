package com.employee.Employee.Allocation.System.repository;

import com.employee.Employee.Allocation.System.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EmployeeRepository
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{    
}
