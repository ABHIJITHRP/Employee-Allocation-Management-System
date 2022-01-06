package com.employee.Employee.Allocation.System.repository;

import java.util.List;

import com.employee.Employee.Allocation.System.entity.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {

    @Query(value = "SELECT * FROM allocation alloc where alloc.employee_id = :employeeId", nativeQuery = true)
    List<Allocation> findByEmpId(Long employeeId);

}
