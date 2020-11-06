package com.mmi.ismatul.employee.repository;

import com.mmi.ismatul.employee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    public Page findAllByRemoveIsFalse(Pageable pageable);
    public Employee findByIdNumber(Integer nip);
    public Employee findByNameContains();
}
