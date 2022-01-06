package com.employee.Employee.Allocation.System.service;

import java.util.List;

import com.employee.Employee.Allocation.System.entity.Allocation;
import com.employee.Employee.Allocation.System.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllocationService {

    @Autowired
    private AllocationRepository allocationRepository;

    // save allocation
    public Allocation saveAllocation(Allocation allocation) {
        return allocationRepository.save(allocation);
    }

    // view specific Allocation
    public List<Allocation> findAllocation(Long employeeId) {
        return allocationRepository.findByEmpId(employeeId);
    }
}
